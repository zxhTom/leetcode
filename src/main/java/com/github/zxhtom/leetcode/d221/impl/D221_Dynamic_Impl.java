package com.github.zxhtom.leetcode.d221.impl;

import com.github.zxhtom.leetcode.d221.D221;

import java.util.Arrays;

public class D221_Dynamic_Impl implements D221 {
    @Override
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        int max = Arrays.stream(dp[0]).max().getAsInt();
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = dp[i - 1][j];
                int left = dp[i][j - 1];
                int left_up_diagnol = dp[i - 1][j - 1];
                if (matrix[i][j] == '1') {
                    int min = Math.min(left_up_diagnol, Math.min(left, up));
                    dp[i][j] = min + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max * max;
    }
}
