package com.github.zxhtom.leetcode.d72.impl;

import com.github.zxhtom.leetcode.d72.D72;

import java.util.Arrays;

public class D72_Practice_Self_Impl implements D72 {
    int[][] dp ;
    String ww1;
    String ww2;
    @Override
    public int minDistance(String word1, String word2) {
        ww1 = word1;
        ww2 = word2;
        int m = word1.length(), n = word2.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        int dfs = dfs(m, n);
        return dfs;
    }

    private int dfs(int m, int n) {
        if (dp[m][n] > -1) {
            return dp[m][n];
        }
        if (ww1.charAt(m - 1) == ww2.charAt(n - 1)) {
            dp[m][n] = dfs(m - 1, n - 1);
        } else {
            dp[m][n] = 1 + Math.min(dfs(m, n - 1), Math.min(dfs(m - 1, n), dfs(m - 1, n - 1)));
        }
        return dp[m][n];
    }
}
