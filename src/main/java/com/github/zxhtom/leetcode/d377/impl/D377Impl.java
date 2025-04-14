package com.github.zxhtom.leetcode.d377.impl;

import com.github.zxhtom.leetcode.d377.D377;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/13
 */
public class D377Impl implements D377 {
    @Override
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
