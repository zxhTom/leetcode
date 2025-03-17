package com.github.zxhtom.leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/22
 */
public class Leetcode198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int[] objects = Arrays.copyOfRange(res, 0, i-1);
            res[i] = nums[i] + Arrays.stream(objects).max().getAsInt();
        }
        return Arrays.stream(res).max().getAsInt();
    }
}
