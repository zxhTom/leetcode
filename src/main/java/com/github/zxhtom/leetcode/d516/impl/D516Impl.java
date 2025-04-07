package com.github.zxhtom.leetcode.d516.impl;

import com.github.zxhtom.annotaions.Ignore;
import com.github.zxhtom.leetcode.d516.D516;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author zxhtom
 * 2025/4/4
 */
@Ignore
public class D516Impl implements D516 {

    @Override
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int max = 1;
        for (int i = 0; i < len-1; i++) {
            dp[i][i] = 1;
            queue.add(new int[]{i, i});
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                max = 2;
                queue.add(new int[]{i, i + 1});
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int m = node[0], n = node[1];
            if (m == 0 || n == len - 1) {
                continue;
            }
            int i = m - 1;
            for (int j = n + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i][j] < dp[m][n] + 2) {
                    dp[i][j] = dp[m][n] + 2;
                    queue.add(new int[]{i, j});
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }

}
