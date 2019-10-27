package com.lukassestic.interviewQuestions.q1;

import java.util.HashSet;
import java.util.Set;

/**
 * An algorithm to determine if a string has all unique characters.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Q1 {

    private static boolean areAllCharactersUnique(String source) {
        Set<Character> charactersSet = new HashSet<>();

        for(Character c: source.toCharArray()) {
            if (charactersSet.contains(c)) {
                return false;
            }

            charactersSet.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testStrings= {"unique", "character", "word"};

        for (String string : testStrings) {
            System.out.println(string + ": " + areAllCharactersUnique(string));
        }
    }
}
