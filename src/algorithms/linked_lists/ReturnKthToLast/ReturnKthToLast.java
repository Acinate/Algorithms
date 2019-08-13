package algorithms.linked_lists.ReturnKthToLast;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;
import algorithms.linked_lists.LinkedListTestData;

public class ReturnKthToLast {

    private LinkedList list = LinkedListTestData.linkedList1();

    private int ReturnKthToLast(LinkedListNode n, int k) {

        int length = 0;
        LinkedListNode current = n;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        int count = 0;
        current = n;
        while (current.next != null) {
            count++;
            current = current.next;
            if (length - count == k) {
                return current.data;
            }
        }


    return -1;

    }

    /* Below is the books solution, does not work. */
    /* Prints out the correct value however does not return the correct value */
    private int RecursiveReturnKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = RecursiveReturnKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println("kth element is " + head.data);
        }

        return index;
    }

    public void RunTests() {

        int result = RecursiveReturnKthToLast(list.getFirst(), 7);
        System.out.println(result);
    }
}
