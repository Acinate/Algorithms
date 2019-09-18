package algorithms.stacks_queues.SortStack;

import java.util.Stack;

public class SortStack {
    public void sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }

        /* Copy the elements from r back into s. */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
