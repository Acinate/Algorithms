package algorithms.trees_graphs;

import algorithms.trees_graphs.RouteBetweenNodes.State;

import java.util.Objects;

public class GraphVertex {
    String label;
    State state;

    public GraphVertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof GraphVertex) {
            return label == ((GraphVertex) o).label;
        } else {
            return false;
        }
    }
}