package com.lukassestic.interviewQuestions.q4;

/**
 * Implement an algorithm to check if it is a permutation of a palindrome
 *
 * IDEA:
 *
 * Time complexity: O(n)
 */
public class Q4 {
    private static int lastLowercaseValue = Character.getNumericValue('z');
    private static int firstLowercaseValue = Character.getNumericValue('a');

    // Assuming we won't receive non-letter values
    private static char toLowercase(char c) {
        int charValue = Character.getNumericValue(c);

        if (charValue >= firstLowercaseValue && charValue <= lastLowercaseValue) {
            return c;
        }

        return (char) (charValue + 32);
    }

    private static int getCharValue(char c) {

        int charValue = Character.getNumericValue(c);

        if (firstLowercaseValue <= charValue && charValue <= lastLowercaseValue) {
            // if c == 'a' returns 0, if c == 'z' returns 25
            return charValue - firstLowercaseValue;
        }

        return -1;
    }

    private static int[] buildCharFreqTable(String string) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];


        for(char c: string.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }

            table[getCharValue(c)]++;
        }

        return table;
    }

    private static boolean isPalindromePermutation(String string) {

        int[] frequencies = buildCharFreqTable(string);

        int oddOnes = 0;
        for(int value: frequencies) {
            if (value % 2 != 0) {
                oddOnes++;
            }

            if (oddOnes > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testStrings = {"Tact Coa", "arc btos at ab sc roa", "kas lu tic ses"};

        for(String string: testStrings) {
            System.out.println(string + ": " + isPalindromePermutation(string));
        }
    }
}
