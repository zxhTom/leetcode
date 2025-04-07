package com.github.zxhtom.leetcode.d72.impl;

import com.github.zxhtom.annotaions.Ignore;
import com.github.zxhtom.leetcode.d72.D72;

import java.util.Arrays;

/**
 * This Situation can't analysc repeat letter
 * eg:
 *     abcdet->c  need step 5 --> initial arr dp[i][0]={1,2,2,3,4,5}
 *     abcdcet->c  need step 6 -> initial arr dp[i][0]={1,2,2,3,3,4,5} this is error where occur second c
 * so the Unit One Result is 26 But Actually one is 27
 * @author zxhtom
 * 2025/4/5
 */
@Ignore
public class D72Impl implements D72 {

    int[][] dp;
    String w1;
    String w2;
    @Override
    public int minDistance(String word1, String word2) {
        if ("".equals(word1) || "".equals(word2)) {
            return Math.abs(word1.length() - word2.length());
        }
        w1 = word1; w2 = word2;
        int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
            if (i == 0) {
                dp[i][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
                continue;
            }
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 1 + dp[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = 1 + dp[0][i - 1];
            }
        }
        int dfs = dfs(m - 1, n - 1);
        if (dfs == Integer.MAX_VALUE) {
            return 0;
        }
        return dfs;
    }

    private int dfs(int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[m][n] >= 0) {
            return dp[m ][n];
        }
        if (w1.charAt(m) == w2.charAt(n)) {
            dp[m][n] = dfs(m - 1, n - 1) ;
        } else {
            dp[m][n] = 1 + Math.min(dfs(m - 1, n - 1), Math.min(dfs(m, n - 1), dfs(m - 1, n)));
        }
        return dp[m][n];
    }

}
