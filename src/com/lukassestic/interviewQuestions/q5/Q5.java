package com.lukassestic.interviewQuestions.q5;

/**
 * Three types of edits can be performed on a string: Insert, edit or a replace.
 * Implement an algorithm that checks if only a single edit was performed on a string
 *
 * Time complexity: O(n)
 */
public class Q5 {

    private static boolean checkForReplacements(String lhs, String rhs) {
        int changes = 0;
        char[] lhsCharArray = lhs.toCharArray();
        char[] rhsCharArray = rhs.toCharArray();

        for (int i = 0; i < lhsCharArray.length; i++) {
            if (lhsCharArray[i] != rhsCharArray[i]) {
                if (++changes > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkForRemovals(String lhs, String rhs) {
        int diff = 0, i = 0;

        char[] lhsCharArray = lhs.toCharArray();
        char[] rhsCharArray = rhs.toCharArray();

        while(i < lhsCharArray.length && (i - diff) < rhsCharArray.length) {
            if (lhsCharArray[i] != rhsCharArray[i - diff]) {
                if(++diff > 1) {
                    return false;
                }
            }

            i++;
        }

        return true;
    }

    private static boolean areSingleEditAway(String lhs, String rhs) {

        int sizeDiff = rhs.length() - lhs.length();

        if (Math.abs(sizeDiff) > 1) {
            return false;
        }

        // To standardize we are going to assume the lhs is of greater or equal length than rhs
        if (sizeDiff > 0) {
            String tmp = lhs;
            lhs = rhs;
            rhs = tmp;
        }

        return sizeDiff == 0 ? checkForReplacements(lhs, rhs) : checkForRemovals(lhs, rhs);
    }

    public static void main(String[] args) {
        String baseline = "pale";
        String[] exampleStrings = {"ple", "pales", "bale", "bake"};

        for(String string: exampleStrings) {
            System.out.println(baseline + " - " + string + ": " + areSingleEditAway(baseline, string));
        }
    }
}
