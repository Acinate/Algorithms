package test.java;

import algorithms.dynamic_programming.TripleStep.TripleStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestDynamicProgramming {

    private TripleStep tripleStep = new TripleStep();

    @Test
    void TestTripleStep() {
        Assertions.assertEquals(4, tripleStep.count(3));
    }
}
