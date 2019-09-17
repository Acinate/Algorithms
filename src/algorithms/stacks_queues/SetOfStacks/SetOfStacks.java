package algorithms.stacks_queues.SetOfStacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity = 10;


    public void push(int v) {
        // get last stack
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(v);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size == 0) stacks.remove(stacks.size() - 1);
        return v;
    }

    private Stack getLastStack() {
        if (stacks.size() <= 0) {
            return null;
        } else {
            return stacks.get(stacks.size()-1);
        }
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    public void RunTests() {
        Test test = new Test();
        test.RunTests();
    }
}

class Stack {
    private int capacity;
    public int size = 0;
    private Node top, bottom;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(int v) {
        if (size >= capacity) return false;
        size++;
        Node n = new Node(v);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class Node {
    int value;
    Node above;
    Node below;

    Node(int v) {
        this.value = v;
    }
}

class Test {
    private int[] DataSet1 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2};

    public void RunTests() {
        SetOfStacks set = new SetOfStacks();
        for (int i : DataSet1) {
            set.push(i);
        }
        set.popAt(0);
    }
}