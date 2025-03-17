package com.github.zxhtom.hacker.DeliveryManagementSystem.impl;

import java.util.*;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/14
 */
public class DeliveryManagementSystem {
    public static int[] dijstraMap(int n , int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0]=0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (Integer next : map.getOrDefault(node[0],new ArrayList<>())) {
                if (distances[next - 1] > distances[node[0] - 1] + 1) {
                    distances[next - 1] = distances[node[0] - 1] + 1;
                    queue.add(new int[]{next, distances[next - 1]});
                }
            }
        }
        return null;
    }
}
