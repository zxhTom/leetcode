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
        Long max = 0L;
        long[] dp = new long[m];
        for (int i = 0; i < m; i++) {
            dp[i] = questions[i][0];
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        for (int i = 0; i < m; i++) {
            int next =i+1+questions[i][1];
            if (next >= m) {
                continue;
            }
            for (int j = next; j <= Math.min(next + questions[next][1], m-1); j++) {
                dp[j] = Math.max(dp[j], dp[i] + questions[j][0]);
                if (max < dp[j]) {
                    max = dp[j];
                }
            }
        }
        return max;
    }
}
