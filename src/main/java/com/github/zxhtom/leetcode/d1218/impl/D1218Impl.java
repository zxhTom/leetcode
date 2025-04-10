package com.github.zxhtom.leetcode.d1218.impl;

import com.github.zxhtom.leetcode.d1218.D1218;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D1218Impl implements D1218 {
    @Override
    public int longestSubsequence(int[] arr, int difference) {
        int m = arr.length;
//        Arrays.sort(arr);
//        difference = Math.abs(difference);
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[m][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        map.put(arr[0], 0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //initial use this node situation , the initial value is 1
            dp[i][1] = 1;
            int prev = arr[i] - difference;
            if (map.containsKey(prev)) {
                dp[i][1] = Math.max(dp[i][1], 1 + dp[map.get(prev)][1]);
            }
            map.put(arr[i], i);
        }
        return Math.max(dp[m - 1][0], dp[m - 1][1]);
    }
}
