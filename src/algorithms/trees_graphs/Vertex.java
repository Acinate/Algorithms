package algorithms.trees_graphs;

import java.util.Objects;

public class Vertex {
    String label;
    Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            return label == ((Vertex) o).label;
        } else {
            return false;
        }
    }

}