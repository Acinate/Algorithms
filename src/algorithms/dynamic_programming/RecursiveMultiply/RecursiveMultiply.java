package algorithms.dynamic_programming.RecursiveMultiply;

public class RecursiveMultiply {
    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        int memo[] = new int[smaller + 1];
        return minProductHelper(smaller, bigger, memo);
    }

    int minProductHelper(int smaller, int bigger, int[] memo) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        }

        /* Compute half. If uneven, compute other half. If even, double it. */
        int s = smaller >> 1; // Divide by 2
        int side1 = minProductHelper(s, bigger, memo);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger, memo);
        }

        /* Sum and cache. */
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }
}
