package algorithms.dynamic_programming.TowerOfHanoi;

import java.util.Stack;

public class Tower {
    Stack<Integer> disks;
    int index;

    public Tower(int n) {
        disks = new Stack<>();
        index = n;
    }

    int index() {
        return index;
    }

    void add(int d) {
        if (!disks.empty() && disks.peek() <= d) {
            System.out.println("Error adding disk");
        } else {
            disks.push(d);
        }
    }

    public int diskCount() {
        return disks.size();
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    private void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }
}
