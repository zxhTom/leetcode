package com.github.zxhtom.leetcode.d714.impl;

import com.github.zxhtom.leetcode.d714.D714;

public class D714Impl implements D714 {
    @Override
    public int maxProfit(int[] prices, int fee) {
        int m = prices.length;
        int[][] dp = new int[m][3];
        /**
         * 0: have stock 's profit
         * 1: none stock 's profit
          */
        dp[0] = new int[]{-prices[0], 0, 0};
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + (prices[i] - fee));
        }
        return dp[m - 1][1];
    }
}
