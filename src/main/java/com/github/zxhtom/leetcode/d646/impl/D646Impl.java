package com.github.zxhtom.leetcode.d646.impl;

import com.github.zxhtom.leetcode.d646.D646;

import java.util.Arrays;

public class D646Impl implements D646 {
    @Override
    public int findLongestChain(int[][] pairs) {
        int m = pairs.length, n = pairs[0].length;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs,(o1,o2)->{
            return o1[0] - o2[0];
        });
        int max = 1;
        for (int i = 1; i < m; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
