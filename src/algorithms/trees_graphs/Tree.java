package algorithms.trees_graphs;

import java.util.*;

public class Tree {

    TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }

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
                temp.left = new TreeNode(value, temp);
                break;
            }
            if (temp.right != null) {
                queue.add(temp.right);
            } else {
                temp.right = new TreeNode(value, temp);
                break;
            }
        }
    }

    public List<Integer> breadthFirstTraversal() {
        List<Integer> visited = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp != null) {
                visited.add(temp.getValue());
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return visited;
    }

    public List<Integer> depthFirstTraversal() {
        List<Integer> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(this.root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                visited.add(temp.getValue());
                if (temp.right != null) {
                    stack.add(temp.right);
                }
                if (temp.left != null) {
                    stack.add(temp.left);
                }
            }
        }
        return visited;
    }

    public TreeNode breadthFirstSearch(int value) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp != null) {
                if (temp.getValue() == value) {
                    return temp;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return null;
    }

    public TreeNode depthFirstSearch(int value) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(this.root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                if (temp.getValue() == value) {
                    return temp;
                }
                if (temp.right != null) {
                    stack.add(temp.right);
                }
                if (temp.left != null) {
                    stack.add(temp.left);
                }
            }
        }
        return null;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = this.root;
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            visited.add(temp.getValue());
            temp = temp.right;
        }
        return visited;
    }

    public List<Integer> preorderTraversal() {
        List<Integer> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(this.root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                visited.add(temp.getValue());
                if (temp.right != null) {
                    stack.add(temp.right);
                }
                if (temp.left != null) {
                    stack.add(temp.left);
                }
            }
        }
        return visited;
    }

    public List<Integer> postorderTraversal() {
        List<Integer> visited = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (this.root == null) {
            return visited;
        }
        s1.push(this.root);
        while (!s1.empty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }
        while (!s2.empty()) {
            visited.add(s2.pop().getValue());
        }
        return visited;
    }
}

