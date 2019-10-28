package com.lukassestic.interviewQuestions.q6;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters
 * eg. aabcccccaaa -> a2b1c5a3
 * If the resulting compression is not smaller than the original just return the original string
 *
 * Assumption: String will only contain Aa - Zz characters
 */
public class Q6 {
    private static int asciiZero = 48;


    private static String countCompress(String string) {
        char[] charArray = string.toCharArray();
        int[] values = new int[charArray.length];

        char observedChar = charArray[0];
        int count = 0;
        int index = 0;
        for(char c: charArray) {

            if (index >= values.length - 2) {
                return string;
            }

            if (c != observedChar) {
                values[index] = observedChar;
                values[index + 1] = count;

                observedChar = c;
                count = 1;

                index += 2;
                continue;
            }

            count++;
        }

        values[index] = observedChar;
        values[index + 1] = count;

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < values.length && values[i] != 0; i+=2) {
            s.append((char) values[i]);
            s.append(values[i + 1]);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        String[] testStrings = {"aabcccccaaa", "aaa"};
        System.out.println(countCompress(testStrings[0]));
        System.out.println(countCompress(testStrings[1]));
    }
}
