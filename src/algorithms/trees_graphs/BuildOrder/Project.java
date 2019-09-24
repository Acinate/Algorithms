package algorithms.trees_graphs.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    public enum State { COMPLETE, PARTIAL, BLANK };
    public State state = State.BLANK;
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() { dependencies++; }
    public void decrementDependencies() { dependencies--; }

    public String getName() { return name; }
    public State getState() { return state; }
    public void setState(State state) {
        this.state = state;
    }
    public ArrayList<Project> getChildren() { return children; }
    public int getNumberDependencies() { return dependencies; }
}
