package algorithms.trees_graphs.FirstCommonAncestor;

import algorithms.trees_graphs.TreeNode;

public class CommonAncestor2 {
    public TreeNode commonAncestor(TreeNode root, TreeNode q, TreeNode p) {
        if (!covers(root, q) || !covers(root, p)) {
            return null;
        } else if (covers(q, p)) {
            return q;
        } else if (covers(p, q)) {
            return p;
        }

        /* Traverse upwards until you find a node that covers q. */
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) return null;
        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
}
