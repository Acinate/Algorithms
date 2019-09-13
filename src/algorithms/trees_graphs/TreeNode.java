package algorithms.trees_graphs;

import java.util.Objects;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Integer) {
            return value == ((Integer) o);
        } else {
            return false;
        }
    }
}
