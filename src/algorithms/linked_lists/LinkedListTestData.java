package algorithms.linked_lists;

public class LinkedListTestData {

    public static LinkedList linkedList0() {
        int[] values = {};
        LinkedList list = new LinkedList();
        list.addAll(values);
        return list;
    }

    public static LinkedList linkedList1() {
        int[] values = {1, 2, 2, 1, 3, 2, 5, 1, 4, 5, 3};
        LinkedList list = new LinkedList();
        list.addAll(values);
        return list;
    }

    public static LinkedList linkedList2() {
        int[] values = {3, 5, 8, 5, 10, 2, 1};
        LinkedList list = new LinkedList();
        list.addAll(values);
        return list;
    }

    public static LinkedList linkedList3() {
        int[] values = {7, 1, 6};
        LinkedList list = new LinkedList();
        list.addAll(values);
        return list;
    }

    public static LinkedList linkedList4() {
        int[] values = {5, 9, 2};
        LinkedList list = new LinkedList();
        list.addAll(values);
        return list;
    }
}
