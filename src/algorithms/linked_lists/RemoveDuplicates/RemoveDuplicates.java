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

    public void runTests() {
        // Populate list
        list = LinkedListTestData.linkedList1();
        deleteDuplicates(list.getFirst());
        System.out.println(list.toString());
    }
}
