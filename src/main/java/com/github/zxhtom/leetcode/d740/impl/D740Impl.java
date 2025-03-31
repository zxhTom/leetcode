package com.github.zxhtom.leetcode.d740.impl;

import com.github.zxhtom.leetcode.d740.D740;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/30
 */
public class D740Impl implements D740 {
    @Override
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums[nums.length - 1] - nums[0] + 3];
        ans[0] = ans[1] = 0;
        int ansIndex = 2;
        int cnt = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt++;
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                if (nums[i] - prev > 1) {
                    ans[ansIndex] = ans[ansIndex-1] + nums[i] * cnt;
                } else {
                    ans[ansIndex] = ans[ansIndex - 2] + nums[i] * cnt;
                }
                if (ans[ansIndex] < ans[ansIndex - 1]) {
                    ans[ansIndex] = ans[ansIndex - 1];
                }
                prev = nums[i];
                ansIndex++;
                cnt = 0;
            }
        }
        return Math.max(ans[ansIndex - 2], ans[ansIndex - 1]);
    }
}
