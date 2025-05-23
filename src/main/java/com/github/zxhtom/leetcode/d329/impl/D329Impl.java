package com.github.zxhtom.leetcode.d329.impl;

import com.github.zxhtom.leetcode.d329.D329;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/17
 */
public class D329Impl implements D329 {
    int m ,n;
    List[][] memoizations ;
    List<int[]> directions = new ArrayList<int[]>() {
        {
            add(new int[]{-1, 0});
            add(new int[]{1, 0});
            add(new int[]{0, 1});
            add(new int[]{0, -1});
        }
    };
    @Override
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        memoizations = new ArrayList[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> dfs = dfs(matrix, i, j);
                if (max < dfs.size()) {
                    max = dfs.size();
                }
            }
        }
        return max;
    }

    public List<Integer> dfs(int[][] matrix , int i, int j) {
        if (memoizations[i][j] != null) {
            return memoizations[i][j];
        }
        int max = 0;
        List<Integer> tmps = new ArrayList<>();
        for (int[] direction : directions) {
            int nextRow = i + direction[0], nextCol = j + direction[1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                continue;
            }
            if (matrix[i][j] < matrix[nextRow][nextCol] && max < dfs(matrix, nextRow, nextCol).size()) {
                tmps=dfs(matrix, nextRow, nextCol);
                max = tmps.size();
            }
        }
        tmps.add(matrix[i][j]);
        return tmps;
    }
}
