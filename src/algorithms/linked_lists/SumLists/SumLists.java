package algorithms.linked_lists.SumLists;

import algorithms.linked_lists.LinkedList;
import algorithms.linked_lists.LinkedListNode;
import algorithms.linked_lists.LinkedListTestData;

public class SumLists {

    LinkedList list1 = LinkedListTestData.linkedList3();
    LinkedList list2 = LinkedListTestData.linkedList4();

    public String[] GetNumbers(LinkedListNode list1, LinkedListNode list2) {

        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();

        while (list1 != null) {
            n1.append(list1.data);
            list1 = list1.next;
        }

        while (list2 != null) {
            n2.append(list2.data);
            list2 = list2.next;
        }
        return new String[] { n1.toString(), n2.toString()};
    }

    public int SumLists(String n1, String n2) {

        int num1 = Integer.parseInt(n1.toString());
        int num2 = Integer.parseInt(n2.toString());

        return num1 + num2;
    }

    public int SumListReverse(String n1, String n2) {
        int num1 = Integer.parseInt(ReverseString(n1.toString()));
        int num2 = Integer.parseInt(ReverseString(n2.toString()));

        return num1 + num2;
    }

    public String ReverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public void RunTests() {
        String[] numbers = GetNumbers(list1.getFirst(), list2.getFirst());
        int result = SumLists(numbers[0],numbers[1]);
        int reverseResult = SumListReverse(numbers[0],numbers[1]);
        System.out.println(result);
        System.out.println(reverseResult);
    }

}
