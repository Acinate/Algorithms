package test.java;

import algorithms.trees_graphs.Graph;
import algorithms.trees_graphs.GraphTestData;
import algorithms.trees_graphs.GraphVertex;
import algorithms.trees_graphs.RouteBetweenNodes.RouteBetweenNodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphsTreesTests {

    private RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();

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
}
