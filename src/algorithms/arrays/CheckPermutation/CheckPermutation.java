package algorithms.arrays.CheckPermutation;

import java.util.HashMap;

public class CheckPermutation {
    public String[] testString1 = {"abcde", "edcab"};
    public String[] testString2 = {"bbacde", "abcde"};
    public String[][] testStrings = {testString1,testString2};

    public boolean isPermutation(String s1, String s2) {
        // Check if the strings are the same length
        if (s1.length() == s2.length()) {
            // Keep count of each letter in each string
            HashMap<Character, Integer> charCounter1 = new HashMap<>();
            for(char c : s1.toCharArray()) {
                if (!charCounter1.containsKey(c)) {
                    charCounter1.put(c,1);
                } else {
                    charCounter1.put(c,charCounter1.get(c) + 1);
                }
            }
            HashMap<Character, Integer> charCounter2 = new HashMap<>();
            for(char c : s1.toCharArray()) {
                if (!charCounter2.containsKey(c)) {
                    charCounter2.put(c,1);
                } else {
                    charCounter2.put(c,charCounter2.get(c) + 1);
                }
            }
            for (char c : charCounter1.keySet()) {
                if (charCounter1.get(c).intValue() == charCounter2.get(c).intValue()) {
                    // Do nothing, same amount of characters
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void runTests() {
        for (String[] testString : testStrings) {
            System.out.println(testString[0] + " is a permutation of " + testString[1] + " : " + isPermutation(testString[0],testString[1]));
        }
    }
}
