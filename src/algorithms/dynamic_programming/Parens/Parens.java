package algorithms.dynamic_programming.Parens;

import java.util.HashSet;
import java.util.Set;

public class Parens {
    public Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    String s = insertInto(str, i);
                    set.add(s);
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    private String insertInto(String str, int leftSide) {
        String left = str.substring(0, leftSide + 1);
        String right = str.substring(leftSide + 1, str.length());
        return left + "()" + right;
    }
}
