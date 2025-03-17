package com.github.zxhtom.leetcode.d1334.impl;


import com.github.zxhtom.leetcode.d1334.D1334;

import java.util.*;

public class D1334_2Impl implements D1334 {
    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        List<int[]>[] edge =  new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int[] ints : edges) {
            edge[ints[0]].add(new int[]{ints[1], ints[2]});
            edge[ints[1]].add(new int[]{ints[0], ints[2]});
        }
        int minx = Integer.MAX_VALUE;
        int resNode = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            tmp[i] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                for (int[] nextList : edge[node]) {
                    if (distanceThreshold >= tmp[i] + nextList[1] && tmp[i] + nextList[1] < tmp[nextList[0]]) {
                        queue.add(nextList[0]);
                        tmp[nextList[0]] = tmp[i] + nextList[1];
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < tmp.length; j++) {
                if (j == i) {
                    continue;
                }
                if (tmp[j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minx) {
                minx = count;
                resNode = i;
            }
        }
        return resNode;
    }
}
