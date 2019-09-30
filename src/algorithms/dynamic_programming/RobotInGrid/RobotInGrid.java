package algorithms.dynamic_programming.RobotInGrid;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGrid {
    public ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }

        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
                            HashSet<Point> failedPoints) {
        if (row < 0 || col < 0 || !maze[row][col]) return false;

        boolean isAtOrigin = (row == 0) && (col == 0);

        Point p = new Point(row, col);

        /* If we've already visited this cell, return */
        if (failedPoints.contains(p)) {
            return false;
        }

        if (isAtOrigin || getPath(maze, row - 1, col, path, failedPoints)
        || getPath(maze, row, col - 1, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p); // Cache result
        return false;
    }
}
