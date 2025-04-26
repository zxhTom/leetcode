package com.github.zxhtom.leetcode.d322.impl;

import com.github.zxhtom.leetcode.d322.D322;

import java.util.Arrays;

public class D322ForwardImpl implements D322 {
    @Override
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i < amount; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue;
                }
                int mul = 1;
                int index = i + coin * mul;
                while (index>=0&&index <= amount) {
                    if (dp[index] <= dp[i] + mul) {
                        break;
                    }
                    dp[index] = dp[i] + mul++;
                    index = i + coin * mul;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
