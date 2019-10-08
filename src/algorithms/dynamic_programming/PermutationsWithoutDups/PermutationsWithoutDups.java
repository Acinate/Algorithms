package algorithms.dynamic_programming.PermutationsWithoutDups;

import java.util.ArrayList;

public class PermutationsWithoutDups {
    public ArrayList<String> getPerms(String str) {
        if (str == null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j=0;j<=word.length();j++) {
                String s = insertCharAt(word,first,j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public ArrayList<String> getPerms2(String remainder) {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();

        /* Base case */
        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i=0; i<len; i++) {
            /* Remove char i and find permutations of remaining chars. */
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms2(before + after);

            /* Prepend char i to each permutation */
            for (String s : partials) {
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }

    private String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}
