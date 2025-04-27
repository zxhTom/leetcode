package com.github.zxhtom.leetcode.d2466.impl;

import com.github.zxhtom.leetcode.d2466.D2466;

public class D2466Impl implements D2466 {
    @Override
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[0] = 1;
        int res = 0;
        for (int i = 0; i < high; i++) {
            if (i + zero <= high) {
                dp[i + zero] += dp[i];
            }
            if (i + one <= high) {
                dp[i + one] += dp[i];
            }
        }

        for (int i = low; i <= high; i++) {
            res += dp[i];
        }
        return res;
    }
}
