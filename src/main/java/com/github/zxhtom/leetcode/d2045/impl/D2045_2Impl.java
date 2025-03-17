package com.github.zxhtom.leetcode.d2045.impl;


import com.github.zxhtom.leetcode.d2045.D2045;

import java.util.*;

public class D2045_2Impl implements D2045 {
    @Override
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            edgesMap.putIfAbsent(edges[i][0], new ArrayList<Integer>());
            edgesMap.putIfAbsent(edges[i][1], new ArrayList<Integer>());
            edgesMap.get(edges[i][0]).add(edges[i][1]);
            edgesMap.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<int[]> queue = new LinkedList<>();
        int start = 1;
        int[][] distance = new int[n+1][2];
        for (int i = 2; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[1][1] = Integer.MAX_VALUE;
        queue.add(new int[]{1, 0});
        while (distance[n][1]==Integer.MAX_VALUE) {
            int[] cur = queue.poll();
            int currentNode=cur[0];
            int path=cur[1];
            for (Integer nextNode : edgesMap.getOrDefault(currentNode,new ArrayList<>())) {
                if (path + 1 < distance[nextNode][0]) {
                    distance[nextNode][0] = path + 1;
                    queue.add(new int[]{nextNode, path + 1});
                }

                if (path + 1 > distance[nextNode][0] && path + 1 < distance[nextNode][1]) {
                    distance[nextNode][1] = path + 1;
                    queue.add(new int[]{nextNode,path+1});

                }
            }
        }
        int total = time;
        for (int i = 1; i < distance[n][1]; i++) {
            int comdual = total % (2 * change);
            if (comdual >= change) {
                total=change - (total % change) + total;
            }
            total += time;
        }
        return total;
    }
}
