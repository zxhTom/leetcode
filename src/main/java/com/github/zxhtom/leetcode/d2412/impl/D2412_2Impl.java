package com.github.zxhtom.leetcode.d2412.impl;

import com.github.zxhtom.leetcode.d2412.D2412;

public class D2412_2Impl implements D2412 {
    @Override
    public long minimumMoney(int[][] transactions) {
        int total = 0;
        int lossTotal = 0;
        for (int[] transaction : transactions) {
            int seprator = transaction[0];
            if (transaction[0] > transaction[1]) {
                //loss status
                lossTotal += transaction[0] - transaction[1];
                seprator = transaction[1];
            }
            if (total < seprator) {
                total = seprator;
            }
        }
        return total+lossTotal;
    }
}
