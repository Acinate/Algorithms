package algorithms.trees_graphs;

import java.util.Objects;

public class GraphVertex {
    String label;
    GraphVertex(String label) {
        this.label = label;
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