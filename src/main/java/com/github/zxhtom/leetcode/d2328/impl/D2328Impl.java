package com.github.zxhtom.leetcode.d2328.impl;

import com.github.zxhtom.annotaions.Primary;
import com.github.zxhtom.leetcode.d2328.D2328;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/16
 * dynamic programming
 * depth-first search  =~ dfs
 * breadth-frist search =~ bfs
 * memoization 记忆搜索
 */
public class D2328Impl implements D2328 {
    List<int[]> directions = new ArrayList<int[]>(){
        {
            add(new int[]{0, -1});
            add(new int[]{1, 0});
            add(new int[]{0, 1});
            add(new int[]{-1, 0});
        }
    };
    int row, col;
    int[][] memoizations ; // memoization
    int mod = 1000000007;
    @Override
    @Primary
    public int countPaths(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        memoizations = new int[row][col];
        int ans = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                ans = (ans+depthFirstSearch(grid, r, c))%mod;
            }
        }
        return ans;
    }

    public int depthFirstSearch(int[][] graph, int startRow, int startCol) {
        int sum = 1;
        if (memoizations[startRow][startCol] != 0) {
            return memoizations[startRow][startCol];
        }
        for (int[] direction : directions) {
            int nextRow = startRow + direction[0], nextCol = startCol + direction[1];
            if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && graph[startRow][startCol] < graph[nextRow][nextCol]) {
                // dynamic programming or recursion or greddy algorithm
                sum = (sum+depthFirstSearch(graph, nextRow, nextCol))%mod;
            }
        }
        return memoizations[startRow][startCol] = sum;
    }
}
