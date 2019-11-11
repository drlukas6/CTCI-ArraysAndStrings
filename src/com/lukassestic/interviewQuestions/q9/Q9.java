package com.lukassestic.interviewQuestions.q9;

/**
 * Check if one string is a rotation of another using only one call to isRotation method.
 * eg. Word "lukas" has a rotation "ukasl"
 *
 * Time complexity: O(n)
 */
public class Q9 {

    private static boolean isRotation(String sub, String of) {
        int length = of.length();
        if (sub.length() != length) {
            return false;
        }
       
        char firstLetter = of.charAt(0);
        int difference = -1;
          
        for(int i = of.length() - 1; i >= 0; i--) {
            if (sub.charAt(i) == firstLetter) {
                difference = i;
                break;
            }
        }

        if (difference == -1) {
            return false;
        }

        String part1 = sub.substring(0, difference);
        String part2 = sub.substring(difference, sub.length());

        return of.equals(part2 + part1);
    }

    public static void main(String[] args){
        String[] bases = {"lukas", "waterbottle", "bruna"};
        String[] rotations = {"kaslu", "erbottlewat", "nabrk"};

        for (int i = 0; i < bases.length; i++) {
            System.out.println(bases[i] + " - " + rotations[i] + " --> " + isRotation(rotations[i], bases[i]));
        }
    }
}
