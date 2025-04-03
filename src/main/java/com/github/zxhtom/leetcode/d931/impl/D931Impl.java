package com.github.zxhtom.leetcode.d931.impl;

import com.github.zxhtom.leetcode.d931.D931;

import java.util.Arrays;

public class D931Impl implements D931 {
    @Override
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[row][cols];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0] = matrix[0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1])+matrix[i][0];
            dp[i][cols - 1] = Math.min(dp[i - 1][cols - 2], dp[i - 1][cols - 1]) + matrix[i][cols - 1];
            for (int j = 1; j < cols - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
            }
        }
        return Arrays.stream(dp[row-1]).min().getAsInt();
    }
}
