package com.github.zxhtom.leetcode.d2140.impl;

import com.github.zxhtom.leetcode.d2140.D2140;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/21
 */
public class D2140Impl implements D2140 {
    @Override
    public long mostPoints(int[][] questions) {
        int m = questions.length;
        Integer max = 0;
        int[][] dp = new int[m+1][2];
        for (int i = 0; i < m; i++) {
            if (dp[i - 1][1] == 1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
            } else {
                dp[i][0] = dp[i - 1][0] + questions[i][0];
                dp[i][1] = 1;
            }
        }
        return 0;
    }
}
