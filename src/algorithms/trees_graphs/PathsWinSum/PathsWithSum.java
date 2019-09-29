package algorithms.trees_graphs.PathsWinSum;

import algorithms.trees_graphs.TreeNode;

public class PathsWithSum {
    public int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        /* Return paths from root node */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        /* Return paths from left and right children */
        int pathsFromLeft = countPathsWithSum(root.left, targetSum);
        int pathsFromRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }

    int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.value;

        int numberOfPaths = 0;
        if (currentSum == targetSum) {
            numberOfPaths++;
        }

        numberOfPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        numberOfPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);

        return numberOfPaths;
    }
}
