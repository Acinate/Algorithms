package algorithms.trees_graphs.BuildOrder;

import java.util.ArrayList;
import java.util.Stack;

public class BuildOrderDFS {
    public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<Project>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; // Cycle
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    /* Build the graph, adding the edge (a, b) if b is dependent on a. Assumes a pair
     *  is listed in "build order". The pair (a, b) in dependencies indicates that b
     *  depends on a and a must be built before b */
    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.createNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    public String[] projectsAsString(Stack<Project> projects) {
        if (projects == null || projects.size() == 0) {
            return null;
        }

        String[] arr = new String[projects.size()];

        int index = 0;
        while (projects.size() > 0) {
            arr[index] = projects.pop().getName();
            index++;
        }
        return arr;
    }
}