package algorithms.trees_graphs.PathsWinSum;

import algorithms.trees_graphs.TreeNode;

import java.util.HashMap;

public class PathsWithSum {
    public int countPathsWithSumHash(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0;

        /* Count paths with sum ending at the current node. */
        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        /* If runningSum equals, recurse, then decrement pathCount. */
        /* Add this path */
        if (runningSum == targetSum) {
            totalPaths++;
        }

        /* Increment pathCount, recurse, then decrement pathCount. */
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }

    public int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        /* Return paths from root node */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        /* Return paths from left and right children */
        int pathsFromLeft = countPathsWithSum(root.left, targetSum);
        int pathsFromRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }

    private int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
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
