package org.sprintdragon.algorithm.lc;

public class Title48 {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j > i && j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2 ; j++) {
                swap(matrix, i, j, i, matrix[i].length - j - 1);
            }
        }
    }

    public void swap(int[][] matrix, int a, int b, int c, int d) {
        int tmp = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = tmp;
    }

}
