package algorithms.trees_graphs.RouteBetweenNodes;

import algorithms.trees_graphs.Graph;
import algorithms.trees_graphs.GraphVertex;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {
    public boolean search(Graph g, GraphVertex search, GraphVertex goal) {
        if (search == goal) return true;
        Queue<GraphVertex> queue = new LinkedList<>();
        for (GraphVertex v : g.getAdjVerticies().keySet()) {
            v.setState(State.Unvisited);
        }
        search.setState(State.Visiting);
        queue.add(search);
        GraphVertex v;
        while (!queue.isEmpty()) {
            v = queue.remove();
            if (v != null) {
                for (GraphVertex u : g.getAdjVerticies().get(v)) {
                    if (u.getState() == State.Unvisited || u.getState() == null) {
                        if (u.getLabel().equals(goal.getLabel())) {
                            return true;
                        } else {
                            u.setState(State.Visiting);
                            queue.add(u);
                        }
                    }
                }
                v.setState(State.Visited);
            }
        }
        return false;
    }
}
