package com.github.zxhtom.leetcode.d1334.impl;


import com.github.zxhtom.leetcode.d1334.D1334;

import java.util.Arrays;

public class D1334_1Impl implements D1334 {
    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dijMap = new int[n][n];
        for (int[] ints : dijMap) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            dijMap[start][end] = weight;
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int[] ints = dijMap[i];
            long count = Arrays.stream(ints).filter(item -> item <= distanceThreshold).count();
            ans[i] = count;
        }
        long min = Long.MAX_VALUE;
        int minIndex = -1;
        for (int i = ans.length - 1; i >= 0; i--) {
            if (min > ans[i]) {
                min = ans[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
}
