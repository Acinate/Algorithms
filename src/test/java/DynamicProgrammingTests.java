package test.java;

import algorithms.dynamic_programming.MagicIndex.MagicIndex;
import algorithms.dynamic_programming.PermutationsWithDuplicates.PermutationsWithDups;
import algorithms.dynamic_programming.PermutationsWithoutDups.PermutationsWithoutDups;
import algorithms.dynamic_programming.PowerSet.PowerSet;
import algorithms.dynamic_programming.RecursiveMultiply.RecursiveMultiply;
import algorithms.dynamic_programming.RobotInGrid.RobotInGrid;
import algorithms.dynamic_programming.TowerOfHanoi.Tower;
import algorithms.dynamic_programming.TowerOfHanoi.TowersOfHanoi;
import algorithms.dynamic_programming.TripleStep.TripleStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class DynamicProgrammingTests {

    private TripleStep tripleStep = new TripleStep();
    private RobotInGrid robotInGrid = new RobotInGrid();
    private MagicIndex magicIndex = new MagicIndex();
    private PowerSet powerSet = new PowerSet();
    private RecursiveMultiply recursiveMultiply = new RecursiveMultiply();
    private TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
    private PermutationsWithoutDups permutationsWithoutDups = new PermutationsWithoutDups();
    private PermutationsWithDups permutationsWithDups = new PermutationsWithDups();

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
        int[] array2 = new int[] {0,1,1,1,5,6,7,8,9,10};
        Assertions.assertEquals(1,magicIndex.magicFast(array));
        Assertions.assertEquals(1,magicIndex.magicFastNonDistinct(array));
        Assertions.assertEquals(1,magicIndex.magicFastNonDistinct(array2));

    }

    @Test
    void TestPowerSet() {
        ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<ArrayList<Integer>> subsets = powerSet.getSubsets(set);
        Assertions.assertNotNull(subsets);
        Assertions.assertEquals(32, subsets.size());
    }

    @Test
    void RecursiveMultiply() {
        Assertions.assertEquals(0, recursiveMultiply.minProduct(0,2));
        Assertions.assertEquals(2, recursiveMultiply.minProduct(1,2));
        Assertions.assertEquals(4, recursiveMultiply.minProduct(2,2));
        Assertions.assertEquals(6, recursiveMultiply.minProduct(3,2));
    }

    @Test
    void TowersOfHanoi() {
        int n = 3;
        Tower[] startTowers = towersOfHanoi.GenerateTowers(n);
        Tower[] endTowers = towersOfHanoi.MoveDisks(startTowers, n);
        Assertions.assertNotNull(startTowers);
        Assertions.assertNotNull(endTowers);
        Assertions.assertEquals(0,endTowers[0].diskCount());
        Assertions.assertEquals(3,endTowers[2].diskCount());
    }

    @Test
    void PermutationsWithoutDups() {
        Assertions.assertEquals(2, permutationsWithoutDups.getPerms("ab").size());
        Assertions.assertEquals(6, permutationsWithoutDups.getPerms("abc").size());
        Assertions.assertEquals(24, permutationsWithoutDups.getPerms("abcd").size());

        Assertions.assertEquals(2, permutationsWithoutDups.getPerms2("ab").size());
        Assertions.assertEquals(6, permutationsWithoutDups.getPerms2("abc").size());
        Assertions.assertEquals(24, permutationsWithoutDups.getPerms2("abcd").size());
    }

    @Test
    void PermutationsWithDups() {
        Assertions.assertEquals(6, permutationsWithDups.printPerms("abc").size());
        Assertions.assertEquals(24, permutationsWithDups.printPerms("abcd").size());
        Assertions.assertEquals(12, permutationsWithDups.printPerms("abbd").size());
    }
}
