package algorithms.linked_lists.LoopDetection;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;

public class LoopDetection {
    private LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        /* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // collision
                break;
            }
        }

        /* Error check - no meeting point, and therefore no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
        * Loop Start. If they move at the same pace, they must meet at Loop Start */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* Both now point to the start of the loop. */
        return fast;
    }

    private LinkedList generateTestData() {
        LinkedList list = new LinkedList();
        int[] values = new int[] {1, 2, 3, 4, 5};
        LinkedListNode head = null;
        for (int i = 0; i < values.length; i++) {
            LinkedListNode node = new LinkedListNode(values[i]);
            if (i == 0) {
                head = node;
            }
            if (i == values.length - 1) {
                node = head;
                list.add(node);
            } else {
            list.add(node);
            }
        }
        return list;
    }

    public void RunTests() {
        LinkedList list = generateTestData();

        LinkedListNode result = FindBeginning(list.getFirst());

        System.out.println(result.data);

        // System.out.println(list.toString());
    }
}
