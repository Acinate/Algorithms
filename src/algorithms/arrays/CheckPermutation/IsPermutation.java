package algorithms.arrays.CheckPermutation;

import java.util.HashMap;

public class IsPermutation {
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption ASCII
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters has no neg values, and therefore no pos values either
    }
}
