package com.github.zxhtom.leetcode.d2104.impl;

import com.github.zxhtom.leetcode.d2104.D2104;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zxhtom
 * 2025/3/23
 */
public class D2104Impl implements D2104 {
    @Override
    public long subArrayRanges(int[] nums) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i], min = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                max=Math.max(nums[j], max);
                min=Math.min(nums[j], min);
                total += max - min;
            }
        }
        return total;
    }
}
