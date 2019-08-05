package algorithms.arrays.OneAway;

public class OneAway {
    // if strings are same length -> check if max 1 character has been modified
    // if original string has length of one less than new -> check if all characters in old string are in new string
    // if original string has length of one more than new -> check if all characters in new string are in old string

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneReplacementAway(first, second);
        } else if (first.length() == second.length() - 1) {
            return oneInsertionAway(first, second);
        } else if (second.length() == first.length() - 1) {
            return oneInsertionAway(second, first);
        } else {
            return false;
        }
    }

    private boolean oneReplacementAway(String first, String second) {
        boolean oneCharDiff = false;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (oneCharDiff) {
                    return false;
                }
                oneCharDiff = true;
            }
        }

        return true;
    }

    private boolean oneInsertionAway(String first, String second) {
        int base = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i + base)) {
                System.out.println(first.charAt(i + base));
                System.out.println(second.charAt(i));
                if (base < 1) {
                    base += 1;
                    i -= 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void runTests() {
        String[] test1 = {"pale", "bae"};
        boolean test1result = oneEditAway(test1[0],test1[1]);
        System.out.println(test1result);
    }
}
