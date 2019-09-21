package algorithms.trees_graphs.CheckBalanced;

import algorithms.trees_graphs.TreeNode;

public class CheckBalanced {
    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left) + 1;
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right) + 1;
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalancedTree(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
