package com.github.zxhtom.leetcode.d221.impl;

import com.github.zxhtom.annotaions.Ignore;
import com.github.zxhtom.leetcode.d221.D221;

import java.util.LinkedList;
import java.util.Queue;


@Ignore
public class D221Impl implements D221 {
    @Override
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int k = 0; k < m; k++) {
            for (int res = 0; res < n; res++) {
                if (matrix[k][res] == '1') {
                    dp[k][res] = 1;
                    queue.add(new int[]{k, res, 1});
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[] nodes = queue.poll();
            int li = nodes[0], lj = nodes[1], dis = nodes[2];
            if (max < dis) {
                max = dis;
            }
            if (dp[li][lj] > 0 && li + 1 < m && lj + 1 < n) {
                if (dp[li + 1][lj + 1] > dp[li][lj]) {
                    continue;
                }
                int index = (int) Math.sqrt(dis);
                int pow = Double.valueOf(Math.pow(1 + index, 2)).intValue();
                boolean flag = true;
                for (int i = li - index + 1; i <= li + 1; i++) {
                    if (matrix[i][lj + 1] == '0') {
                        flag = false;
                        break;
                    }
                }
                if(!flag){
                    continue;
                }
                for (int j = lj + 1 - index; j <= lj + 1; j++) {
                    if (matrix[li + 1][j] == '0') {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    continue;
                }
                if (dp[li + 1][lj + 1] < pow) {
                    dp[li + 1][lj + 1] = pow;
                    queue.add(new int[]{li + 1, lj + 1, pow});
                }
            }
        }
/*
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
*/
        return max;
    }
}
