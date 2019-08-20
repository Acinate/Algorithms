package algorithms.linked_lists.Palindrome;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;
import algorithms.linked_lists.LinkedListTestData;

public class Palindrome {

    private LinkedList list = LinkedListTestData.linkedList5();

    private boolean LinkedListsEqual(LinkedList l1, LinkedList l2) {
        LinkedListNode c1 = l1.getFirst();
        LinkedListNode c2 = l2.getFirst();

        while (c1 != null) {
            if (c1.data == c2.data) {
                c1 = c1.next;
                c2 = c2.next;
            } else {
                return false;
            }
        }

        if (c1 == null && c2 == null) {
            return true;
        }
        return false;
    }

    private LinkedList ReverseLinkedList(LinkedList list) {
        LinkedListNode prev = null, current = null, next = null;
        current = list.getFirst();

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return new LinkedList(prev);

    }

    public void RunTests() {

        LinkedList reversedList = ReverseLinkedList(LinkedListTestData.linkedList5());
        boolean result = LinkedListsEqual(list, reversedList);

        System.out.println(list.toString());
        System.out.println(reversedList.toString());

        System.out.println(result);
    }

}
