package algorithms.trees_graphs;

import java.util.Objects;

public class TreeNode {
    public int value;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode parent) {
        this.value = value;
        this.parent = parent;
    }

    public int getValue() {
        return  this.value;
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
