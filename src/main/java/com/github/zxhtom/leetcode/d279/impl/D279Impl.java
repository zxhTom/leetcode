package com.github.zxhtom.leetcode.d279.impl;

import com.github.zxhtom.leetcode.d279.D279;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/11
 */
public class D279Impl implements D279 {
    @Override
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int extration = (int) Math.sqrt(i);
            for (int j = extration; j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
