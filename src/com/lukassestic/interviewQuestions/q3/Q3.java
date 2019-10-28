package com.lukassestic.interviewQuestions.q3;

/**
 * Replace all spaces in a string with '%20'
 * Trailing and leading whitespace should be eliminated
 *
 * Assumption: String has enough trailing space for adding '%20's
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Q3 {
    private static String urlifyString(String source, int contentLength) {

        // Working on and directly modifying source char array
        char[] sourceArray = source.toCharArray();
        int contentIndex = contentLength - 1;
        int i = sourceArray.length - 1;

        // Going backwards because we know that the trailing spaces on the end account for '%20's we are inserting
        while (i >= 0 && contentIndex >= 0) {
            if (sourceArray[contentIndex] == ' ') {
                sourceArray[i] = '0';
                sourceArray[i - 1] = '2';
                sourceArray[i - 2] = '%';
                i -= 3;
            } else {
                sourceArray[i--] = sourceArray[contentIndex];
            }

            contentIndex--;
        }


        return new String(sourceArray);
    }

    public static void main(String[] args) {
        String[] testStrings = {"Mr John Smith    ", "Lukas Sestic  ", "Type Here  "};
        int[] contentLengths = {13, 12, 9};

        for (int i = 0; i < testStrings.length; i++) {
            System.out.println(urlifyString(testStrings[i], contentLengths[i]));
        }
    }
}
