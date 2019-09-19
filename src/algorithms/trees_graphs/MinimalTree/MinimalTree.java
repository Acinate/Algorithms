package algorithms.trees_graphs.MinimalTree;

import algorithms.trees_graphs.TreeNode;

public class MinimalTree {
    public TreeNode createMinimalTree(int[] array) {
        return createMinimalTree(array, 0, array.length - 1);
    }

    private TreeNode createMinimalTree(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalTree(array, start, mid - 1);
        n.right = createMinimalTree(array, mid + 1, end);
        return n;
    }
}
