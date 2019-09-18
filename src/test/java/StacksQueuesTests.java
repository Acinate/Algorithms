package test.java;

import algorithms.stacks_queues.SortStack.SortStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StacksQueuesTests {

    SortStack sortStack = new SortStack();

    @Test
    public void testSortStack() {
        Stack<Integer> testStack1 = new Stack<>();
        testStack1.add(5);
        testStack1.add(3);
        testStack1.add(1);
        testStack1.add(2);
        testStack1.add(4);
        sortStack.sortStack(testStack1);

        List<Integer> values = new ArrayList<>();
        while (!testStack1.isEmpty()) {
            values.add(testStack1.pop());
        }

        Assertions.assertEquals(values.toArray()[0], new int[] { 1, 2, 3, 4, 5 }[0]);
        Assertions.assertEquals(values.toArray()[1], new int[] { 1, 2, 3, 4, 5 }[1]);
        Assertions.assertEquals(values.toArray()[2], new int[] { 1, 2, 3, 4, 5 }[2]);
        Assertions.assertEquals(values.toArray()[3], new int[] { 1, 2, 3, 4, 5 }[3]);
        Assertions.assertEquals(values.toArray()[4], new int[] { 1, 2, 3, 4, 5 }[4]);
    }
}
