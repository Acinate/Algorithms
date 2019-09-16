package algorithms.stacks_queues.StackMin;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int min = Math.min(value, min());
        super.push(new NodeWithMin(value, min));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }

    public void RunTests() {
        StackWithMin stack = new StackWithMin();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int min = stack.min();
        System.out.println(min);
    }
}

class NodeWithMin {
    public int value;
    public int min;

    public NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}
