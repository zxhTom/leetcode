package com.github.zxhtom.leetcode.d2045.impl;

import com.github.zxhtom.leetcode.d2045.D2045;

import java.util.*;

public class D2045Impl implements D2045 {
    @Override
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int[][] distances = new int[n][2];
        for (int i = 0; i < distances.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        List<Integer>[] mapArr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mapArr[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            mapArr[edge[0]-1].add(edge[1]-1);
            mapArr[edge[1]-1].add(edge[0]-1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (distances[n - 1][1] == Integer.MAX_VALUE) {
            int[] crr = queue.poll();
            int current=crr[0],len=crr[1];
            for (Integer o : mapArr[current]) {
                if (len + 1 < distances[o][0]) {
                    distances[o][0] = len + 1;
                    queue.add(new int[]{o,len + 1});
                }else if (len + 1 > distances[o][0] && len + 1 < distances[o][1]) {
                    distances[o][1] = len + 1;
                    queue.add(new int[]{o,len + 1});
                }
            }
        }
        int total = 0;

        for (int k = 0; k < distances[n - 1][1]; k++) {
            int mod = (total) % (2 * change);
            if (mod >= 0 && mod < change) {
                total += time;
            } else {
                total = (total / change + 1) * change + time;
            }
        }
        return total;
    }
}
