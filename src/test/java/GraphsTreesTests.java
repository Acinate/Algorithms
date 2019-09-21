package test.java;

import algorithms.trees_graphs.CheckBalanced.CheckBalanced;
import algorithms.trees_graphs.Graph;
import algorithms.trees_graphs.GraphTestData;
import algorithms.trees_graphs.GraphVertex;
import algorithms.trees_graphs.ListOfDepths.ListOfDepths;
import algorithms.trees_graphs.MinimalTree.MinimalTree;
import algorithms.trees_graphs.RouteBetweenNodes.RouteBetweenNodes;
import algorithms.trees_graphs.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphsTreesTests {

    private RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
    private MinimalTree minimalTree = new MinimalTree();
    private ListOfDepths listOfDepths = new ListOfDepths();
    private CheckBalanced checkBalanced = new CheckBalanced();

    @Test
    void TestRouteBetweenNodes() {
        Graph data = new GraphTestData().Graph1();

        boolean bob_bob = routeBetweenNodes.search(data, new GraphVertex("Rob"), new GraphVertex("Bob"));
        boolean rob_maria = routeBetweenNodes.search(data, new GraphVertex("Rob"), new GraphVertex("Maria"));
        boolean maria_rob = routeBetweenNodes.search(data, new GraphVertex("Maria"), new GraphVertex("Rob"));
        boolean rob_chucky = routeBetweenNodes.search(data, new GraphVertex("Rob"), new GraphVertex("Chucky"));
        boolean chucky_rob = routeBetweenNodes.search(data, new GraphVertex("Chucky"), new GraphVertex("Rob"));
        boolean alice_rob = routeBetweenNodes.search(data, new GraphVertex("Alice"), new GraphVertex("Rob"));
        boolean rob_alice = routeBetweenNodes.search(data, new GraphVertex("Rob"), new GraphVertex("Alice"));
        boolean alice_bob = routeBetweenNodes.search(data, new GraphVertex("Alice"), new GraphVertex("Bob"));
        boolean rob_bob = routeBetweenNodes.search(data, new GraphVertex("Rob"), new GraphVertex("Bob"));
        boolean alice_maria = routeBetweenNodes.search(data, new GraphVertex("Alice"), new GraphVertex("Maria"));

        // Same Path
        Assertions.assertTrue(bob_bob);
        // Direct Paths
        Assertions.assertTrue(rob_maria);
        Assertions.assertTrue(maria_rob);
        Assertions.assertTrue(alice_rob);
        // No Direct Paths
        Assertions.assertFalse(rob_alice);
        Assertions.assertFalse(alice_bob);
        Assertions.assertFalse(rob_bob);
        Assertions.assertFalse(alice_maria);
        // Chucky doesn't know anybody, should return false
        Assertions.assertFalse(rob_chucky);
        // Chucky doesn't know anybody, should return false
        Assertions.assertFalse(chucky_rob);
    }

    @Test
    void TestMinimalTree() {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        TreeNode node = minimalTree.createMinimalTree(array);

        // Middle node
        Assertions.assertEquals(node.value, 5);
        // Left subtree
        Assertions.assertEquals(node.left.value, 2);
        Assertions.assertEquals(node.left.left.value, 1);
        Assertions.assertEquals(node.left.right.value, 3);
        Assertions.assertEquals(node.left.right.right.value, 4);
        // Right subtree
        Assertions.assertEquals(node.right.value, 8);
        Assertions.assertEquals(node.right.left.value, 6);
        Assertions.assertEquals(node.right.left.right.value, 7);
        Assertions.assertEquals(node.right.right.value, 9);
        Assertions.assertEquals(node.right.right.right.value, 10);
    }

    @Test
    void TestListOfDepthsDFT() {
        int[] array = new int[] { 1,2,3,4,5,6,7,8,9,10 };
        TreeNode root = minimalTree.createMinimalTree(array);

        ArrayList<LinkedList<TreeNode>> lists = listOfDepths.createLevelLinkedListsDFT(root);

        // Test height of tree
        Assertions.assertEquals(lists.size(), 4);
        // Test LinkedList contents of height = 1
        Assertions.assertEquals(lists.get(0).size(), 1);
        Assertions.assertEquals(lists.get(0).get(0).value, 5);
        // Test LinkedList contents of height = 2
        Assertions.assertEquals(lists.get(1).size(), 2);
        Assertions.assertEquals(lists.get(1).get(0).value, 2);
        Assertions.assertEquals(lists.get(1).get(1).value, 8);
        // Test LinkedList contents of height = 3
        Assertions.assertEquals(lists.get(2).size(), 4);
        Assertions.assertEquals(lists.get(2).get(0).value, 1);
        Assertions.assertEquals(lists.get(2).get(1).value, 3);
        Assertions.assertEquals(lists.get(2).get(2).value, 6);
        Assertions.assertEquals(lists.get(2).get(3).value, 9);
        // Test LinkedList contents of height = 3
        Assertions.assertEquals(lists.get(3).size(), 3);
        Assertions.assertEquals(lists.get(3).get(0).value, 4);
        Assertions.assertEquals(lists.get(3).get(1).value, 7);
        Assertions.assertEquals(lists.get(3).get(2).value, 10);
    }

    @Test
    void TestListOfDepthsBFT() {
        int[] array = new int[] { 1,2,3,4,5,6,7,8,9,10 };
        TreeNode root = minimalTree.createMinimalTree(array);

        ArrayList<LinkedList<TreeNode>> lists = listOfDepths.createLevelLinkedListBFT(root);

        // Test height of tree
        Assertions.assertEquals(lists.size(), 4);
        // Test LinkedList contents of height = 1
        Assertions.assertEquals(lists.get(0).size(), 1);
        Assertions.assertEquals(lists.get(0).get(0).value, 5);
        // Test LinkedList contents of height = 2
        Assertions.assertEquals(lists.get(1).size(), 2);
        Assertions.assertEquals(lists.get(1).get(0).value, 2);
        Assertions.assertEquals(lists.get(1).get(1).value, 8);
        // Test LinkedList contents of height = 3
        Assertions.assertEquals(lists.get(2).size(), 4);
        Assertions.assertEquals(lists.get(2).get(0).value, 1);
        Assertions.assertEquals(lists.get(2).get(1).value, 3);
        Assertions.assertEquals(lists.get(2).get(2).value, 6);
        Assertions.assertEquals(lists.get(2).get(3).value, 9);
        // Test LinkedList contents of height = 3
        Assertions.assertEquals(lists.get(3).size(), 3);
        Assertions.assertEquals(lists.get(3).get(0).value, 4);
        Assertions.assertEquals(lists.get(3).get(1).value, 7);
        Assertions.assertEquals(lists.get(3).get(2).value, 10);
    }

    @Test
    void TestCheckBalanced() {
        int[] array;
        array  = new int[] { 1,2,3 };
        TreeNode balancedTree = minimalTree.createMinimalTree(array);
        array  = new int[] { 1,2,3,4,5,6 };
        TreeNode unbalancedTree = minimalTree.createMinimalTree(array);


        boolean balanced = checkBalanced.isBalancedTree(balancedTree);
        boolean unbalanced = checkBalanced.isBalancedTree(unbalancedTree);
        Assertions.assertTrue(balanced);
        Assertions.assertFalse(unbalanced);
    }
}
