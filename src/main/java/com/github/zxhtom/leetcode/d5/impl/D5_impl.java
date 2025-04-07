package com.github.zxhtom.leetcode.d5.impl;

import com.github.zxhtom.leetcode.d5.D5;

import java.util.LinkedList;
import java.util.Queue;

public class D5_impl implements D5 {
    @Override
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 1) {
            return "";
        }
        int[][] dp = new int[len][len];
        dp[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int max = 1;
        int[] pos = new int[2];
        for (int i = 1; i < len; i++) {
            queue.add(new int[]{i, i});
            dp[i][i] = 1;
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = 2;
                if (max < dp[i - 1][i]) {
                    max = dp[i - 1][i];
                    pos = new int[]{i - 1, i};
                }
                queue.add(new int[]{i - 1, i});
            }
/*
            if (i + 1 < len && s.charAt(i + 1) == s.charAt(i)) {
                dp[i][i + 1] = 2;
                queue.add(new int[]{i, i + 1});
            }
*/
        }
        while (!queue.isEmpty()) {
            int[] positions = queue.poll();
            int x = positions[0], y = positions[1];
            if (x - 1 >= 0 && y + 1 < len && s.charAt(x - 1) == s.charAt(y + 1)) {
                dp[x - 1][y + 1] = 2 + dp[x][y];
                if (max < dp[x - 1][y + 1]) {
                    max = dp[x - 1][y + 1];
                    pos = new int[]{x - 1, y + 1};
                }
                queue.add(new int[]{x - 1, y + 1});
            }
            if (x - 1 >= 0 && s.charAt(x - 1) == s.charAt(x)) {

            }
        }
        return s.substring(pos[0], pos[1] + 1);
    }
}
