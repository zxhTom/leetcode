package com.github.zxhtom.leetcode.d300.impl;

import com.github.zxhtom.leetcode.d300.D300;

import java.util.Arrays;

public class D300Impl implements D300 {
    @Override
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
