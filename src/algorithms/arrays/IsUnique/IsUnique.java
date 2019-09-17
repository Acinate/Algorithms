package algorithms.arrays.IsUnique;

public class IsUnique {
    public boolean isUnique(String testString) {
        // If the string length is greater than 128, there must be a repeating character
        if (testString.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < testString.length(); i++) {
            int val = testString.charAt(i);
            // if our character value map contains a value of true, we've already come across this character
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }
}
