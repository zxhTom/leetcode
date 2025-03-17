package com.github.zxhtom.leetcode.d2713.impl;

import com.github.zxhtom.annotaions.Primary;
import com.github.zxhtom.leetcode.d2713.D2713;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/16
 * memoization 记忆搜索
 * dynamic programming 动态规划
 * depth-first search  深度搜索
 * recursive 递归
 *
 */
public class D2713Impl implements D2713 {
    int row , col;
    int[][][] memoizations;
    int template = 1111;
    @Primary
    @Override
    public int maxIncreasingCells(int[][] mat) {
        row = mat.length;
        col = mat[0].length;
        memoizations = new int[row][col][2];
        int res = 1;
        for (int i = 0; i < row; i++) {
            boolean ib = false;
            for (int j = 0; j < col; j++) {
                if (res < dfs(mat, i, j)[0]) {
                    res = dfs(mat, i, j)[0];
                    /*if ((dfs(mat, i, j)[1] & template) == 0b0010) {
                        break;
                    }*/
                    if ((dfs(mat, i, j)[1] & template) == 0b1000) {
                        ib = true;
                    }
                }
            }
            if (ib) {
                break;
            }
        }
        return res;

    }

    public int[] dfs(int[][] mat, int startRow, int startCol) {
        int[] res = new int[2];
        if (memoizations[startRow][startCol][0] > 0) {
            return memoizations[startRow][startCol];
        }
        int sum = 0;
        int direction = 0;
        for (int i = 0; i < row; i++) {
            if (startRow == i) {
                continue;
            }
            if (mat[i][startCol] > mat[startRow][startCol] && sum < dfs(mat, i, startCol)[0]) {
                sum = dfs(mat, i, startCol)[0];
                direction += Math.pow(2, 2 >> (Math.abs(i - startRow) / (i - startRow)));
            }
        }
        direction = direction << 2;
        for (int j = 0; j < col; j++) {
            if (startCol == j) {
                continue;
            }
            if (mat[startRow][j] > mat[startRow][startCol] && sum < dfs(mat, startRow, j)[0]) {
                sum = dfs(mat, startRow, j)[0];
                direction += Math.pow(2, 2 >> (Math.abs(j - startCol) / (j - startCol)));
                direction = direction & 0b0011;
            }
        }
        return memoizations[startRow][startCol] = new int[]{sum+1,direction};
    }
}
