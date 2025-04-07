package com.github.zxhtom.leetcode.d516.impl;

import com.github.zxhtom.leetcode.d516.D516;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/5
 */
public class D516_Dynamic_Impl implements D516 {
    int[][] dp;
    String str;
    @Override
    public int longestPalindromeSubseq(String s) {
        str = s;
        int len = s.length();
        dp = new int[len + 2][len + 2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], i, dp[i].length, -1);
        }
        int max = 1;
        for (int i = 0; i < len; i++) {
            dp[i+1][i+1] = 1;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i + 1][i + 2] = 2;
                if (max < dp[i + 1][i + 2]) {
                    max = dp[i + 1][i + 2];
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = dfs(i , j);
                if (max < tmp) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    public int dfs(int row, int col) {
        if (dp[row+1][col+1] > 0) {
            return dp[row+1][col+1];
        }
        if (str.charAt(row) == str.charAt(col)) {
            dp[row+1][col+1] = 2 + dfs(row + 1, col - 1);
        } else {
            dp[row + 1][col + 1] = Math.max(dfs((row), col - 1), dfs(row + 1, col));
        }
        return dp[row + 1][col + 1];
    }
}
