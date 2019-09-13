package algorithms.trees_graphs.TreeTraversal;

import algorithms.trees_graphs.Tree;
import algorithms.trees_graphs.TreeTestData;

public class TreeTraversal {

    Tree tree = TreeTestData.Tree1();

    public void RunTests() {
        System.out.println("DFT:");
        System.out.println(tree.depthFirstTraversal());
        System.out.println("\nBFT:");
        System.out.println(tree.breadthFirstTraversal());
        System.out.println("\nIn Order Traversal:");
        System.out.println(tree.inorderTraversal());
        System.out.println("\nPre Order Traversal:");
        System.out.println(tree.preorderTraversal());
        System.out.println("\nPost Order Traversal:");
        System.out.println(tree.postorderTraversal());
    }
}
