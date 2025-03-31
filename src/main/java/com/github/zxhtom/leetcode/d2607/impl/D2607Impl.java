package com.github.zxhtom.leetcode.d2607.impl;

import com.github.zxhtom.leetcode.d2607.D2607;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/29
 */
public class D2607Impl implements D2607 {
    @Override
    public long makeSubKSumEqual(int[] arr, int k) {
        long total = 0;
        int length = arr.length;
        int groupSize = gcd(length, k);
        int size = length / groupSize;
        int[] tmp = new int[size];
        for (int i = 0; i < groupSize; i++) {
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = arr[j * groupSize + i];
            }
            Arrays.sort(tmp);
            for (int m = 0; m < tmp.length / 2; m++) {
                total += tmp[tmp.length - 1 - m] - tmp[m];
            }
        }
        return total;
    }
    private Integer gcd(int a , int b) {
        int min = a > b ? b : a;
        for (int i = min; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
