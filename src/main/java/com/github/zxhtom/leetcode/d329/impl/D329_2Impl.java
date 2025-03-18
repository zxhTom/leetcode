package com.github.zxhtom.leetcode.d329.impl;

import com.github.zxhtom.leetcode.d329.D329;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/17
 */
public class D329_2Impl implements D329 {
    List<int[]> directions = new ArrayList<int[]>() {
        {
            add(new int[]{-1, 0});
            add(new int[]{1, 0});
            add(new int[]{0, 1});
            add(new int[]{0, -1});
        }
    };
    int[][] memoizations ;
    int m , n;
    @Override
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        memoizations = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dfs = dfs(matrix, i, j);
                if (max < dfs) {
                    max = dfs;
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int startRow, int startCol) {
        if (memoizations[startRow][startCol] > 0) {
            return memoizations[startRow][startCol];
        }
        int max = 0;
        for (int[] direction : directions) {
            int nextRow = startRow + direction[0], nextCol = startCol + direction[1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                continue;
            }
            if (matrix[startRow][startCol] < matrix[nextRow][nextCol] && max < dfs(matrix, nextRow, nextCol)) {
                max = dfs(matrix, nextRow, nextCol);
            }
        }
        return memoizations[startRow][startCol] = max + 1;
    }
}
