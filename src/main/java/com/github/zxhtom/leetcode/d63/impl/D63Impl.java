package com.github.zxhtom.leetcode.d63.impl;

import com.github.zxhtom.leetcode.d63.D63;

public class D63Impl implements D63 {
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && i == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int total = 0;
                if (i - 1 >= 0&&obstacleGrid[i-1][j]!=1) {
                    total += dp[i - 1][j];
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) {
                    total += dp[i][j - 1];
                }
                dp[i][j] = total;
            }
        }
        return dp[m - 1][n - 1];
    }
}
