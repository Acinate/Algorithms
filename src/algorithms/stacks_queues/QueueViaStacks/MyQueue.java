package algorithms.stacks_queues.QueueViaStacks;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        /* Push onto stackNewest, which always has the newest elements on top */
        stackNewest.push(value);
    }

    /* Move elements from stackNewest into stackOldest. This is usually done so that
     * we can do operations on stackOldest. */
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.pop();
    }

    public void RunTests() {
        Test t = new Test();
        t.RunTests();
    }
}

class Test {
    public void RunTests() {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        MyQueue queue = new MyQueue();
        for (int i : arr) {
            queue.add(i);
        }
    }
}
