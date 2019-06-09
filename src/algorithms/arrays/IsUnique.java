package algorithms.arrays;

public class IsUnique {
    private String testString1 = "This is a string";
    private String testString2 = "2 + 2 = 4";
    private String testString3 = "Racer123";
    private String testString4 = "AaBbCc";
    private String[] testStrings = {testString1, testString2, testString3, testString4};

    private boolean isUnique(String testString) {
        for (int i=0;i<testString.length();i++) {
            for (int j=0;j<testString.length();j++) {
                if (i != j) {
                    if (testString.charAt(i) == testString.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void RunTests() {
        for (String testString : testStrings) {
            System.out.println(testString + " Is Unique: " + isUnique(testString));
        }
    }
}
