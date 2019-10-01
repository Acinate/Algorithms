package test.java;

import algorithms.dynamic_programming.MagicIndex.MagicIndex;
import algorithms.dynamic_programming.RobotInGrid.RobotInGrid;
import algorithms.dynamic_programming.TripleStep.TripleStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

class TestDynamicProgramming {

    private TripleStep tripleStep = new TripleStep();
    private RobotInGrid robotInGrid = new RobotInGrid();
    private MagicIndex magicIndex = new MagicIndex();

    @Test
    void TestTripleStep() {
        Assertions.assertEquals(4, tripleStep.count(3));
        Assertions.assertEquals(4, tripleStep.countWays(3));
    }

    @Test
    void TestRobotInGrid() {
        boolean[][] maze = {
                {true, true, false},
                {false, true, false},
                {false, true, false},
                {false, true, true}
        };

        ArrayList<Point> path = robotInGrid.getPath(maze);

        Assertions.assertNotNull(path);
        Assertions.assertEquals(6, path.size());
    }

    @Test
    void TestMagicIndex() {
        int[] array = new int[] {0,1,2,3,5,6,7,8,9,10};
        int index = magicIndex.magicFast(array);
        Assertions.assertEquals(1,index);
    }
}
