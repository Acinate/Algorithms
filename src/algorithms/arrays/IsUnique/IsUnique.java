package algorithms.arrays.IsUnique;

public class IsUnique {
    private String testString1 = "This is a string";
    private String testString2 = "2 + 2 = 4";
    private String testString3 = "Racer123";
    private String testString4 = "AaBbCc";
    private String[] testStrings = {testString1, testString2, testString3, testString4};

    private boolean isUnique(String testString) {
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

    public void RunTests() {
        for (String testString : testStrings) {
            System.out.println(testString + " Is Unique: " + isUnique(testString));
        }
    }
}
