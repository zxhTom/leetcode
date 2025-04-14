package com.github.zxhtom.leetcode.d96.impl;

import com.github.zxhtom.leetcode.d96.D96;

public class D96Impl implements D96 {
    @Override
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
