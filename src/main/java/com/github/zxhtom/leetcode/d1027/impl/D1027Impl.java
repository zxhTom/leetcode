package com.github.zxhtom.leetcode.d1027.impl;

import com.github.zxhtom.leetcode.d1027.D1027;

import java.util.*;

/**
 * @author zxhtom
 * 2025/4/8
 */
public class D1027Impl implements D1027 {
    @Override
    public int longestArithSeqLength(int[] nums) {
        int m = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int different = max - min;
        int res = 1;
        for (int i = -different; i <= different; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int prev = num - i;
                if (prev >= min && prev <= max && map.containsKey(prev)) {
                    map.put(num, Math.max(map.getOrDefault(num, 1), map.get(prev) + 1));
                    res = Math.max(res, map.get(num));
                }
                map.put(num, map.getOrDefault(num, 1));
            }
        }
        return res;
    }
}
