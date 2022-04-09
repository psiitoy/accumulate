package org.sprintdragon.algorithm.lc.dp;

public class Dp62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[j-1][i] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int process(int m, int n) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return process(m - 1, n) + process(m, n - 1);
    }

}
