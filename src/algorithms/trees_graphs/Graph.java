package algorithms.trees_graphs;

import java.util.*;

public class Graph {
    private Map<GraphVertex, List<GraphVertex>> adjVerticies = new HashMap<>();

    public Map<GraphVertex, List<GraphVertex>> getAdjVerticies() {
        return adjVerticies;
    }

    public List<GraphVertex> getAdjVerticies(String label) {
        // find vertex with this label
        return adjVerticies.get(new GraphVertex(label));
    }

    public void setAdjVerticies(Map<GraphVertex, List<GraphVertex>> verticies) {
        adjVerticies = verticies;
    }

    void addVertex(String label) {
        GraphVertex v = new GraphVertex(label);
        adjVerticies.putIfAbsent(new GraphVertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        GraphVertex v = new GraphVertex(label);
        adjVerticies.values().stream().forEach(e -> e.remove(v));
        adjVerticies.remove(new GraphVertex(label));
    }

    void addEdge(String label1, String label2) {
        GraphVertex v1 = new GraphVertex(label1);
        GraphVertex v2 = new GraphVertex(label2);
        adjVerticies.get(v1).add(v2);
        adjVerticies.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        GraphVertex v1 = new GraphVertex(label1);
        GraphVertex v2 = new GraphVertex(label2);
        List<GraphVertex> eV1 = adjVerticies.get(v1);
        List<GraphVertex> eV2 = adjVerticies.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (GraphVertex v : graph.getAdjVerticies(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (GraphVertex v : graph.getAdjVerticies(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
