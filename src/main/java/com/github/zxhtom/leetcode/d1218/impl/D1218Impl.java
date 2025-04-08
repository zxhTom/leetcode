package com.github.zxhtom.leetcode.d1218.impl;

import com.github.zxhtom.leetcode.d1218.D1218;

import java.util.Arrays;

public class D1218Impl implements D1218 {
    @Override
    public int longestSubsequence(int[] arr, int difference) {
        int m = arr.length;
//        Arrays.sort(arr);
//        difference = Math.abs(difference);
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < m; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] - arr[j] == difference) {
                    dp[i] = 1 + dp[j];
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                    break;
                }
            }
        }
        return  max;
    }
}
