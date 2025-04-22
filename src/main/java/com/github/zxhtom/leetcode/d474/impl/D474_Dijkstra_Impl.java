package com.github.zxhtom.leetcode.d474.impl;

import com.github.zxhtom.leetcode.d474.D474;

import java.util.LinkedList;
import java.util.Queue;

public class D474_Dijkstra_Impl implements D474 {
    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        int max = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = node[0]; i < len; i++) {
                int zerolen = strs[i].length() - strs[i].replaceAll("0", "").length();
                int onelen = strs[i].length() - zerolen;
                if (zerolen + node[1] > m || onelen + node[2] > n) {
                    dp[i + 1] = dp[i];
                    queue.add(new int[]{i + 1, zerolen + node[1], onelen + node[2]});
                    continue;
                }
                dp[i + 1][zerolen + node[1]][onelen + node[2]] = Math.max(dp[i][node[1]][node[2]] + 1, dp[i + 1][zerolen + node[1]][onelen + node[2]]);
                if (max < dp[i + 1][zerolen + node[1]][onelen + node[2]]) {
                    max = dp[i + 1][zerolen + node[1]][onelen + node[2]];
                }
                queue.add(new int[]{i + 1, zerolen + node[1], onelen + node[2]});
            }
        }
        return max;
    }
}
