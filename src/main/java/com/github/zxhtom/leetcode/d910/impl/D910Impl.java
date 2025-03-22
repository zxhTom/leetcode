package com.github.zxhtom.leetcode.d910.impl;

import com.github.zxhtom.leetcode.d910.D910;

import java.util.Arrays;

public class D910Impl implements D910 {
    @Override
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmax = Math.max(nums[i] + k, nums[n - 1] - k);
            int tmin = nums[0] +k;
            if (i < n - 1) {
                tmin = Math.min(nums[0] + k, nums[i + 1] - k);
            }
            if (min > (tmax - tmin)) {
                min = tmax - tmin;
            }
        }
        return min;
    }
}
