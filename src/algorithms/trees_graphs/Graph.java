package algorithms.trees_graphs;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVerticies = new HashMap<>();

    public Map<Vertex, List<Vertex>> getAdjVerticies() {
        return adjVerticies;
    }

    public List<Vertex> getAdjVerticies(String label) {
        // find vertex with this label
        return adjVerticies.get(new Vertex(label));
    }

    public void setAdjVerticies(Map<Vertex, List<Vertex>> verticies) {
        adjVerticies = verticies;
    }

    void addVertex(String label) {
        Vertex v = new Vertex(label);
        adjVerticies.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVerticies.values().stream().forEach(e -> e.remove(v));
        adjVerticies.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVerticies.get(v1).add(v2);
        adjVerticies.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVerticies.get(v1);
        List<Vertex> eV2 = adjVerticies.get(v2);
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
                for (Vertex v : graph.getAdjVerticies(vertex)) {
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
            for (Vertex v : graph.getAdjVerticies(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
