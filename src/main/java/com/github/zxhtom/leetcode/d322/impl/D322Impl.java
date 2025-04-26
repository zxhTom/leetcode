package com.github.zxhtom.leetcode.d322.impl;

import com.github.zxhtom.annotaions.Ignore;
import com.github.zxhtom.leetcode.d322.D322;

import java.util.Arrays;

@Ignore
public class D322Impl implements D322 {
    int[] dp ;
    int[] source;
    @Override
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0]=0;
        source = coins;
        return dfs(amount);
    }

    private int dfs(int amount) {
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] > -1) {
            return dp[amount];
        }
        int minimum = Integer.MAX_VALUE;
        for (int item : source) {
            int dfs = dfs(amount - item);
            if (dfs > -1 && minimum > dfs) {
                minimum = dfs;
            }
        }
        if (minimum == Integer.MAX_VALUE) {
            dp[amount ] = -1;
        } else {
            dp[amount ] = minimum + 1;
        }
        return dp[amount ];
    }
}
