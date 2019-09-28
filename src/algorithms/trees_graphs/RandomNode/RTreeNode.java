package algorithms.trees_graphs.RandomNode;

import java.util.Random;

public class RTreeNode {
    private int data;
    private int size;
    public RTreeNode left;
    public RTreeNode right;

    public RTreeNode(int d) {
        data = d;
        size = 1;
    }

    public RTreeNode getRandomNode() {
        int leftSide = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSide) {
            return left.getRandomNode();
        } else if (index == leftSide) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new RTreeNode(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new RTreeNode(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public RTreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public int data() {
        return data;
    }

    public int size() {
        return size;
    }
}
