package com.github.zxhtom.leetcode.d2713.impl;

import com.github.zxhtom.annotaions.Primary;
import com.github.zxhtom.leetcode.d2713.D2713;

import java.util.*;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/16
 */
public class D2713_2Impl implements D2713 {

    @Primary
    @Override
    public int maxIncreasingCells(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] rows = new int[row], cols = new int[col];
        Map<Integer, List<int[]>> edgeMap = new TreeMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                edgeMap.putIfAbsent(mat[i][j], new ArrayList<>());
                edgeMap.get(mat[i][j]).add(new int[]{i, j});
            }
        }
        for (Integer key : edgeMap.keySet()) {
            List<Integer> maxs = new ArrayList<>();
            for (int[] items : edgeMap.get(key)) {
                maxs.add(Math.max(rows[items[0]], cols[items[1]]) + 1);
            }
            for (int i = 0; i < edgeMap.get(key).size(); i++) {
                int[] items = edgeMap.get(key).get(i);
                int nm = maxs.get(i);
                rows[items[0]]=Math.max(nm,rows[items[0]]);
                cols[items[1]] = Math.max(nm, cols[items[1]]);
            }
        }
        return Arrays.stream(rows).max().getAsInt();
    }
}
