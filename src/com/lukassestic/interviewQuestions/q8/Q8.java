package com.lukassestic.interviewQuestions.q8;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a matrix of M x N make it that when there is a zero, the whole column and line turns to zero
 *
 * eg.
 * 1    2    3    4
 * 5    6    0    8
 * 9    10   11   12
 *
 * becomes:
 * 1    2    0    4
 * 0    0    0    0
 * 9    10   0    12
 *
 * IDEA: Iterate through the matrix, when there is a zero, nullify the row and column, but remember the column.
 * Continue the search on the next row. If we find a zero in a column we don't have track, zero it and remember the column
 * Time complexity: O(M x N)
 * Space complexity: O(N) < Considering we remember all N rows in a hash set
 */
public class Q8 {
    private static void zeroOutRow(int[][] matrix, int rowToZeroOut, int numberOfColumns) {
        matrix[rowToZeroOut] = new int[numberOfColumns];
    }

    private static void zeroOutColumn(int[][] matrix, int columnToZeroOut, int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
           matrix[i][columnToZeroOut] = 0;
        }
    }

    private static void zeroOutIndexes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Set<Integer> affectedColumns = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (affectedColumns.contains(j)) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    affectedColumns.add(j);
                    zeroOutRow(matrix, i, cols);
                    zeroOutColumn(matrix, j, rows);
                    break;
                }
            }
        }
    }

    private static void printOut(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 0, 7}, {8, 9, 10, 11}};
        int[][] test2 = new int[][]{{0, 2, 3, 4}, {5, 6, 3, 7}, {8, 9, 10, 0}};
        zeroOutIndexes(test2);
        printOut(test2);
    }
}
