package com.lukassestic.interviewQuestions.q7;

/**
 * Given an image represented with a NxN matrix of Int values, could you rotate it by 90%
 * Extra challenge: Rotate it in place (No extra memory)
 *
 * In:
 *  1 2 3 (0, 0) -> (2, 0)
 *  4 5 6
 *  7 8 9
 *
 *  Out:
 *  7 4 1
 *  8 5 2
 *  9 6 3
 */
public class Q7 {
    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n / 2 + 1); i++) {
            for (int j = i; j < n - 1 - i; j++) {
                // Grabbing elements
                int element1 = matrix[i][j];
                int element2 = matrix[j][n - 1 - i];
                int element3 = matrix[n - 1 - i][n - 1 - j];
                int element4 = matrix[n - 1 - j][i];

                // Swapping elements
                matrix[i][j] = element4;
                matrix[j][n - 1 - i] = element1;
                matrix[n - 1 - i][n - 1 - j] = element2;
                matrix[n - 1 - j][i] = element3;
                printMatrix(matrix);
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] example = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] example2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(rotateMatrix(example));
        printMatrix(rotateMatrix(example2));
    }
}
