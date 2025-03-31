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
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            cnt++;
            if (nums[i] - nums[i - 1] > 1) {
                ans[i] = ans[0] + nums[i] * cnt;
                cnt = 0;
            } else if (nums[i] - nums[i - 1] == 1) {
                if (ans[i - 1] < cnt * nums[i]) {
                    ans[i] = cnt * nums[i];
                } else {
                    ans[i] = ans[i - 1];
                }
                cnt = 0;
            } else {
                if (ans[i - 1] < cnt * nums[i]) {
                    ans[i] = cnt * nums[i];
                } else {
                    ans[i] = ans[i - 1];
                }
            }
        }
        return 0;
    }
}
