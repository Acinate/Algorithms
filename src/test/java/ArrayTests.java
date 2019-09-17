package test.java;

import algorithms.arrays.CheckPermutation.IsPermutation;
import algorithms.arrays.IsUnique.IsUnique;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTests {

    private IsUnique isUnique = new IsUnique();
    private IsPermutation isPermutation = new IsPermutation();

    @Test
    void isUnique() {
        final boolean test1 = isUnique.isUnique("This is a string");
        final boolean test2 = isUnique.isUnique("2 + 2 = 4");
        final boolean test3 = isUnique.isUnique("Racer123");
        final boolean test4 = isUnique.isUnique("AaBbCc");

        Assertions.assertFalse(test1);
        Assertions.assertFalse(test2);
        Assertions.assertTrue(test3);
        Assertions.assertTrue(test4);
    }

    @Test
    void checkPermutation() {
        final boolean test1 = isPermutation.isPermutation("abcde", "edcab");
        final boolean test2 = isPermutation.isPermutation("bbacde", "abcde");

        Assertions.assertTrue(test1);
        Assertions.assertFalse(test2);
    }
}
