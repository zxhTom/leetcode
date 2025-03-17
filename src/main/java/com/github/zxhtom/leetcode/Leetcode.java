package com.github.zxhtom.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/18
 */
public class Leetcode {
    public static void main(String[] args) {
        Leetcode leetcode = new Leetcode();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
//        int i = leetcode.minPathSum(grid);
//        System.out.println(i);
        int j = leetcode.minPathSumDijsktra(grid);
    }

    public int minPathSumDijsktra(int[][] grid) {
        List<Integer> visited = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        Integer i = 0;
        Integer j = 0;
        int[] pre = {};
        Map<String, Integer> minMap = new HashMap<>();
        minMap.put("00", grid[0][0]);
        while (m * n > visited.size()) {
            int lineCost = grid[i + 1][j] + grid[i][j];
            int columnCost = grid[i][j+1] + grid[i][j];
            String ij = new StringBuffer(i+1).append(j).toString();
            String ji = new StringBuffer(j+1).append(i).toString();
            if (minMap.getOrDefault(ij, Integer.MAX_VALUE) > lineCost) {
                visited.add(i * 10 + j);
                minMap.put(ij, lineCost);
            }
            if (minMap.getOrDefault(ji, Integer.MAX_VALUE) > lineCost) {
                visited.add(j * 10 + i);
                minMap.put(ji, lineCost);
            }
        }
        return 0;
    }
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0]=grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            res[i][0] = grid[i][0]+res[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            res[0][i]=grid[0][i]+res[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                int min = Math.min(res[i - 1][j]+grid[i][j], res[i][j - 1]+grid[i][j]);
                res[i][j]=min;
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }
}
