package com.github.zxhtom.leetcode.d120.impl;

import com.github.zxhtom.leetcode.d120.D120;

import java.util.*;

public class D120Impl implements D120 {
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        List<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(0);
        int cr = 1;
        while (cr < row) {
            list.addAll(queue);
            queue.clear();
            for (Integer poll : list) {
                List<Integer> rows = triangle.get(cr);
                for (Integer k = poll; k <= poll + 1; k++) {
                    if (rows.get(k) + dp[cr - 1][poll] < dp[cr][k]) {
                        dp[cr][k] = rows.get(k) + dp[cr - 1][poll];
                        queue.add(k);
                    }
                }
            }
            cr++;
        }
        return Arrays.stream(dp[row-1]).min().getAsInt();
    }
}
