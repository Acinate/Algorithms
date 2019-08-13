package algorithms.linked_lists;

public class LinkedList {
    LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(LinkedListNode n) {
        this.head = n;
    }

    public LinkedListNode getFirst() {
        return this.head;
    }

    public void add(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this.head;
        if (n != null) {
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        } else {
            this.head = end;
        }
    }

    public void addAll(int[] data) {
        for (int d : data) {
            add(d);
        }
    }

    LinkedListNode deleteNode(LinkedListNode head, int d) {
        LinkedListNode n = head;

        if (n.data == d) {
            return head.next; /* moved head */
        }

        while (n.next != null) {
            if (n.next.data == d) {
                return head; /* head didn't change */
            }
            n = n.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        LinkedListNode current = this.head;
        while (current != null) {
            stringBuilder.append(current.data);
            current = current.next;
            if (current != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


