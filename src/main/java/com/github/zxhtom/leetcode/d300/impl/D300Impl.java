package com.github.zxhtom.leetcode.d300.impl;

import com.github.zxhtom.leetcode.d300.D300;

import java.util.Arrays;

public class D300Impl implements D300 {
    int[][] dp ;
    @Override
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 1;
        }
        int res = dfs(nums,0, len - 1);
        return res;
    }

    private int dfs(int[] nums ,int start, int end) {
        if (dp[start][end] > -1) {
            return dp[start][end];
        }
        int max =1;
        for (int i = start+1; i <= end; i++) {
            for (int j = i-1; j >= start; j--) {
                int tmp = 0;
                if (nums[i] > nums[j]) {
                    tmp = dfs(nums, start, j) + dfs(nums, i, end);
                } else {
                    tmp = Math.max(dfs(nums, start, j), dfs(nums, i, end));
                }
                if (max < tmp) {
                    max = tmp;
                }
            }
        }
        return dp[start][end] = max;
    }
}
