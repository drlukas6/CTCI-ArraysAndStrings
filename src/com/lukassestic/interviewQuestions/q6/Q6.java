package com.lukassestic.interviewQuestions.q6;


/**
 * Implement a method to perform basic string compression using the counts of repeated characters
 * eg. aabcccccaaa -> a2b1c5a3
 * If the resulting compression is not smaller than the original just return the original string
 *
 * Assumption: String will only contain Aa - Zz characters
 *
 * Time complexity: O(n)
 */
public class Q6 {

    private static int compressionLength(String ofString) {
        int compressionLength = 0, count = 0;
        char observedChar = ofString.charAt(0);

        for(int i = 0 ; i < ofString.length(); i++) {
            if (ofString.charAt(i) != observedChar || i == ofString.length() - 1) {
                compressionLength += 1 + String.valueOf(count).length();
                observedChar = ofString.charAt(i);
                continue;
            }
            count++;
        }

        return compressionLength;
    }

    private static String compress(String string, int compressionLength) {
        StringBuilder s = new StringBuilder(compressionLength);

        int count = 0;
        char observedChar = string.charAt(0);

        for(int i = 0 ; i < string.length(); i++) {
            if (string.charAt(i) != observedChar) {
                s.append(observedChar);
                s.append(count);
                observedChar = string.charAt(i);
                count = 1;
                continue;
            }
            count++;
        }

        s.append(observedChar);
        s.append(count);

        return s.toString();
    }

    private static String countCompress(String string) {
        int compressionLength = compressionLength(string);

        if (compressionLength >= string.length()) {
            return string;
        }

        return compress(string, compressionLength);
    }

    public static void main(String[] args) {
        String[] testStrings = {"aabcccccaaa", "aaa", "aaaaaaaaaaaaaaaaaaaa", "aa"};
        for (String testString : testStrings) {
            System.out.println(countCompress(testString));
        }
    }
}
