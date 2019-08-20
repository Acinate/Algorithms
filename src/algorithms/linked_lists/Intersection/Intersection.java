package algorithms.linked_lists.Intersection;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;

public class Intersection {

    private LinkedList list1;
    private LinkedList list2;

    public Intersection() {
        this.generateTestData();
    }

    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null | list2 == null) { return null; }

        /* Get tail and sizes */
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection */
        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size > result2.size ? list1 : list2;

        /* Advance the pointer for the longer linked list by difference in lengths. */

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        /* Return either one */
        return longer;
    }

    class Result {
        public LinkedListNode tail;
        public int size;
        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while(current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public void RunTests() {
    LinkedListNode result = findIntersection(list1.getFirst(),list2.getFirst());
    System.out.println(result.data);
    }

    private void generateTestData() {
        int[] values1 = {3, 1, 5, 9, 7, 2, 1};
        int[] values2 = {-1, -1, 4, 6, 7, 2, 1};

        list1 = new LinkedList();
        list2 = new LinkedList();
        boolean linked = false;

        for (int i=0;i<values1.length; i++) {
            if (values1[i] == values2[i]) {
                // Create the same node
                LinkedListNode node = new LinkedListNode(values1[i]);
                list1.add(node);
                if (!linked) {
                    list2.add(node);
                    linked = true;
                }
            } else {
                // Create different nodes
                LinkedListNode node = new LinkedListNode(values1[i]);
                if (values1[i] != -1) {
                    list1.add(node);
                }
                if (values2[i] != -1) {
                    node = new LinkedListNode(values2[i]);
                    list2.add(node);
                }
            }
        }

        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }

}
