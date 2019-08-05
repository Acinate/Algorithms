package algorithms.arrays.PalindromePermutation;

public class PalindromePermutation {

    private boolean isPermutationOfPalindrome(String phrase) {

        int[] table = buildCharFrequencyTable(phrase);
        boolean maxOneOdd = checkMaxOneOdd(table);

        return maxOneOdd;
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        // Visit each element in table, ignore 0's and 2's
        for (int i =0; i < table.length; i++) {
            if (table[i] % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private int getCharNumber(Character c) {

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    private int[] buildCharFrequencyTable(String phrase) {

        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    public void runTests() {
        String test1 = "Taco Cat";
        boolean test1result = isPermutationOfPalindrome(test1);
        System.out.println(test1result);
    }

}
