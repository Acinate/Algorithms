package algorithms.trees_graphs.FirstCommonAncestor;

import algorithms.trees_graphs.TreeNode;

public class CommonAncestor1 {
    public TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = getDepth(p) - getDepth(q);
        TreeNode first = delta > 0 ? q : p;
        TreeNode second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));

        /* Find where the paths intersect */
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
