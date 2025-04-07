package com.github.zxhtom.leetcode.d72.impl;

import com.github.zxhtom.leetcode.d72.D72;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/6
 */
public class D72_Standout_Impl implements D72 {
    @Override
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j]));
                }
            }
        }
        return dp[m][n];
    }
}
