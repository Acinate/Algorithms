package algorithms.linked_lists.Partition;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;
import algorithms.linked_lists.LinkedListTestData;

public class Partition {

    private LinkedList list = LinkedListTestData.linkedList2();

    public LinkedListNode Partition(int x) {

        // Create two linked lists
        LinkedList less = new LinkedList();
        LinkedList more = new LinkedList();

        // Iterate through original list
        LinkedListNode current = list.getFirst();
        LinkedListNode lessNode = null;
        LinkedListNode moreNode = null;
        while (current != null) {
            if (current.data < x) {
                // Add to less
                if (less.getFirst() == null) {
                    lessNode = new LinkedListNode(current.data);
                    less.setHead(lessNode);
                } else {
                    lessNode = lessNode.next = new LinkedListNode(current.data);
                }
            } else {
                // Add to more
                if (more.getFirst() == null) {
                    moreNode = new LinkedListNode(current.data);
                    more.setHead(moreNode);
                } else {
                    moreNode = moreNode.next = new LinkedListNode(current.data);
                }
            }
            current = current.next;
        }

        // Merge the lists
        lessNode.next = more.getFirst();

        return less.getFirst();
    }

    public void RunTests() {
        LinkedList list = new LinkedList();
        list.setHead(Partition(5));
        System.out.println(list.toString());
    }
}
