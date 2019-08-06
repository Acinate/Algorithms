package algorithms.arrays.StringCompression;

public class StringCompression {

    // Input:      "aabcccccaaa"
    // Output:     "a2b1c5a3"
    // Edge case: If new string is longer than original, return original

    private String StringCompression(String str) {
        String compressedString = CompressString(str);

        return compressedString.length() < str.length() ? compressedString : str;
    }

    private String CompressString(String str) {
        String result = "";
        char c = '@'; // assuming that characters range from a - z
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                if (count != 0) {
                    result += c + "" + count;
                }
                c = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
            if (i == str.length() - 1) {
                result += c + "" + count;
            }
        }

        return result;
    }

    public void test() {
        String test1 = "aabcccccaaa";
        String expect1 = "a2b1c5a3";
        String result1 = StringCompression(test1);
        System.out.println(result1);
    }
}
