package org.sprintdragon.algorithm.lc;

public class Title329 {

    public static void main(String[] args) {
        int[][] a = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Title329 test = new Title329();
        System.out.println(test.longestIncreasingPath(a));
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 不用纠结 matrix[toRow][toColumn] < matrix[row][column]还是matrix[toRow][toColumn] > matrix[row][column]
     * 因为逆序和顺序最大值是一样的，如果求路径需要关心
     * 需要使用记忆化搜索
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, dp));
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] dp) {
        if (dp[row][column] != 0) {
            return dp[row][column];
        }
        int curMaxLen = 1;
        for (int[] pair : dir) {
            int toRow = row + pair[0];
            int toColumn = column + pair[1];
            if (toRow >= 0 && toRow < matrix.length && toColumn >= 0 && toColumn < matrix[0].length
                    && matrix[toRow][toColumn] < matrix[row][column]) {
                curMaxLen = Math.max(curMaxLen, dfs(matrix, toRow, toColumn, dp) + 1);
            }
        }
        dp[row][column] = curMaxLen;
        return curMaxLen;
    }

}
