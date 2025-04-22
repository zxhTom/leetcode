package com.github.zxhtom.leetcode.d474.impl;

import com.github.zxhtom.leetcode.d474.D474;

public class D474Impl implements D474 {
    /**
     *
     * @param strs
     * @param m the maxium of zero
     * @param n the maxium of one
     * @return
     */
    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        int max = 0;
        for (int i = 1; i <= strs.length; i++) {
            int zerolen = strs[i-1].length() - strs[i-1].replaceAll("0", "").length();
            int onelen = strs[i-1].length() - zerolen;
            dp[i] = dp[i - 1];
            for (int x = 0; x <= m - zerolen; x++) {
                for (int y = 0; y <= n-onelen; y++) {
                    dp[i][x][y] = Math.max(dp[i][x][y], dp[i - 1][x + zerolen][y + onelen] + 1);
                    if (max < dp[i][x][y]) {
                        max = dp[i][x][y];
                    }
                }
            }

        }
        return max;
    }

}
