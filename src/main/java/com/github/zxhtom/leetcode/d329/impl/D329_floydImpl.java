package com.github.zxhtom.leetcode.d329.impl;

import com.github.zxhtom.leetcode.d329.D329;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/17
 */
public class D329_floydImpl implements D329 {
    int m , n;
    int[][] memoizations , paths;
    @Override
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        memoizations = new int[m][n];
        paths = new int[m][n];
        return new D329_2Impl().longestIncreasingPath(matrix);
    }
}
