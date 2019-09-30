package algorithms.dynamic_programming.RobotInGrid;

import java.awt.*;
import java.util.ArrayList;

public class RobotInGrid {
    public ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }

        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if (row < 0 || col < 0 || !maze[row][col]) return false;

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(maze, row - 1, col, path)
        || getPath(maze, row, col - 1, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }
}
