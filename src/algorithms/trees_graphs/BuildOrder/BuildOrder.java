package algorithms.trees_graphs.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {
    /* Find the correct build order */
    public Project[] finalBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
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

    /* Return a list of the projects a correct build order. */
    Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        /* Add "roots" to the build order first */
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            /* We have a circular dependency since there are no remaining projects
            *  with zero dependencies. */
            if (current == null) {
                return null;
            }

            /* Remove myself as a dependency */
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }

            /* Add children that have no one depending on them. */
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    /* A helper function to insert projects with zero dependencies into the order
    *  array, starting at index offset. */
    int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    public String[] projectsAsString(Project[] projects) {
        if (projects != null && projects.length > 0) {
            String[] arr = new String[projects.length];

            for (int i=0;i<projects.length;i++) {
                arr[i] = projects[i].getName();
            }
            return arr;
        }
        return null;
    }
}