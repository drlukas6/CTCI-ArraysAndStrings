package com.lukassestic.interviewQuestions.q2;

import java.util.Arrays;

/**
 * Algorithm to check if one string is a permutation of another
 * Time complexity: O(nLog(n))
 * Space complexity: O(n)
 */
public class Q2 {
    private static boolean arePermutations(String lhs, String rhs) {
        if (lhs.length() != rhs.length()) {
            return false;
        }

        char[] lhsArray = lhs.toCharArray();
        char[] rhsArray = rhs.toCharArray();

        Arrays.sort(lhsArray);
        Arrays.sort(rhsArray);

        return Arrays.equals(lhsArray, rhsArray);
    }

    public static void main(String[] args) {
        String[] testLhs = {"god", "race", "word"};
        String[] testRhs = {"dog", "care", "with"};

        for (int i = 0; i < testLhs.length; i++) {
            String lhs = testLhs[i];
            String rhs = testRhs[i];
            System.out.println(lhs + " - " + rhs + ": " + arePermutations(lhs, rhs));
        }
    }

}
