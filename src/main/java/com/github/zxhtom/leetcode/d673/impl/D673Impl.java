package com.github.zxhtom.leetcode.d673.impl;

import com.github.zxhtom.leetcode.d673.D673;

import java.util.Arrays;

public class D673Impl implements D673 {
    @Override
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[2][len];
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[0][i] < 1 + dp[0][j]) {
                        dp[0][i] = 1 + dp[0][j];
                        dp[1][i] = dp[1][j];
                    } else if (dp[0][i] == 1 + dp[0][j]) {
                        dp[1][i] += dp[1][j];
                    }
                }
            }
        }
        int maxLen = 1;
        int ans = 0;
        for (int i = len-1; i >= 0; i--) {
            if (dp[0][i] > maxLen) {
                maxLen = dp[0][i];
                ans = dp[1][i]; // 重置计数
            } else if (dp[0][i] == maxLen) {
                ans += dp[1][i];
            }
        }
        return ans;
    }
}
