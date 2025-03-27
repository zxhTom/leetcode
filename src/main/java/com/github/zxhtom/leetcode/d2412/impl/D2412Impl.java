package com.github.zxhtom.leetcode.d2412.impl;

import com.github.zxhtom.leetcode.d2412.D2412;

public class D2412Impl implements D2412 {
    @Override
    public long minimumMoney(int[][] transactions) {
        long totalLoseMoney = 0;
        long total = 0;
        for (int[] transaction : transactions) {
            int sperater = transaction[0];
            if (transaction[0] > transaction[1]) {
                totalLoseMoney += transaction[0] - transaction[1];
                sperater = transaction[1];
            }
            if (total < sperater) {
                total = sperater;
            }
        }

        return total+totalLoseMoney;
    }
}
