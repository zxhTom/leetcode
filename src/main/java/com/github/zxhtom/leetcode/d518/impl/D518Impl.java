package com.github.zxhtom.leetcode.d518.impl;

import com.github.zxhtom.leetcode.d518.D518;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/12
 */
public class D518Impl implements D518 {
    @Override
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
