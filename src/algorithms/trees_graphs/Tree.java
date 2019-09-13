package algorithms.trees_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    TreeNode root;

    void addNode(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
            return;
        }
        TreeNode temp = this.root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        while(!queue.isEmpty()) {
            temp = queue.remove();
            if (temp == null) {
                temp = new TreeNode(value);
                break;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            } else {
                temp.left = new TreeNode(value);
                break;
            }
            if (temp.right != null) {
                queue.add(temp.right);
            } else {
                temp.right = new TreeNode(value);
                break;
            }
        }
    }

}

