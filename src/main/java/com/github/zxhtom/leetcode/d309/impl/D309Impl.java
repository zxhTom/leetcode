package com.github.zxhtom.leetcode.d309.impl;

import com.github.zxhtom.leetcode.d309.D309;

public class D309Impl implements D309 {
    @Override
    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[][] dp = new int[m][3];
        /**
         * 0 : this stock 's profit
         * 1 : cooldown days 's profit
         * 2 : none this stock ' s profit
         */
        dp[0] = new int[]{-prices[0], 0, 0};
        for (int i = 1; i < m; i++) {
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            for (int j = i - 1; j >= 0; j--) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
        }
        return Math.max(dp[m - 1][1], dp[m - 1][2]);
    }
}
