package algorithms.linked_lists.DeleteMiddleNode;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;
import algorithms.linked_lists.LinkedListTestData;

public class DeleteMiddleNode {

    private LinkedList list = LinkedListTestData.linkedList1();

    private void DeleteMiddleNode(LinkedListNode head) {

        // Find the length of the list
        int length = 1;
        LinkedListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        // 6 / 2 = 3
        // 7 / 2 = 3

        // Not allowed to return first or last node
        // Make sure that element is greater than 1 and less than length

        int element = length / 2;

        if (element != 1 && element != length) {
            int count = 0;
            current = head;
            LinkedListNode prev = null;
            while (current.next != null) {
                count++;
                if (count == element) {
                    // prev doesnt change
                    prev.next = current.next;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
    }

    public void RunTests() {
        System.out.println(list.toString());
        DeleteMiddleNode(list.getFirst());
        System.out.println(list.toString());
    }

}
