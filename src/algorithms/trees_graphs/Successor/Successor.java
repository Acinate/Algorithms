package algorithms.trees_graphs.Successor;

import algorithms.trees_graphs.TreeNode;

public class Successor {
    public TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) return null;

        if (node.right != null) {
            return leftMostChild(node.right);
        } else {
            TreeNode q = node;
            TreeNode x = node.parent;
            // Go up until we are on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private TreeNode leftMostChild(TreeNode node) {
        if (node == null) return null;

        if (node.left != null) {
            return leftMostChild(node.left);
        } else {
            return node;
        }
    }
}
