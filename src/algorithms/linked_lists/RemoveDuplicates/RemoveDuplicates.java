package algorithms.linked_lists.RemoveDuplicates;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;
import algorithms.linked_lists.LinkedListTestData;

import java.util.HashSet;
public class RemoveDuplicates {

    LinkedList list;

    void deleteDuplicates(LinkedListNode n)  {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    void deleteDuplicatesNoBuffer(LinkedListNode n) {
        LinkedListNode current = n;
        while (current != null) {
            /* Remove all future nodes that have the same value */
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void runTests() {
        // Populate list
        list = LinkedListTestData.linkedList1();
        deleteDuplicatesNoBuffer(list.getFirst());
        System.out.println(list.toString());
    }
}
