package algorithms.trees_graphs.FirstCommonAncestor;

import algorithms.trees_graphs.TreeNode;

public class CommonAncestor3 {
    public TreeNode commonAncestor(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null || root == q || root == p) {
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.right, q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;

        return commonAncestor(childSide, q, p);
    }

    boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;

        return covers(root.left, p) || covers(root.right, p);
    }
}
