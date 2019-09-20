package algorithms.trees_graphs.ListOfDepths;

import algorithms.trees_graphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    private void createLevelLinkedListsDFT(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) { // Level has not been reached yet, create a new LL for it
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedListsDFT(root.left, lists, level + 1);
        createLevelLinkedListsDFT(root.right, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedListsDFT(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedListsDFT(root, lists, 0);
        return lists;
    }
}
