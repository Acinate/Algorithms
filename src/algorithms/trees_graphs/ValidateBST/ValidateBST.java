package algorithms.trees_graphs.ValidateBST;

import algorithms.trees_graphs.TreeNode;

public class ValidateBST {
    boolean checkBST(TreeNode node, int min, int max) {
        if (node == null) return true;

        if ((min != Integer.MIN_VALUE && node.value <= min) || (max != Integer.MAX_VALUE && node.value > max)) {
            return false;
        }

        if (!checkBST(node.left, Integer.MIN_VALUE, node.value) || (!checkBST(node.right, node.value,
                Integer.MAX_VALUE))) {
            return false;
        }
        return true;
    }

    public boolean checkBST(TreeNode node) {
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
