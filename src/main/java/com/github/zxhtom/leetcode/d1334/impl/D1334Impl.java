package com.github.zxhtom.leetcode.d1334.impl;

import com.github.zxhtom.annotaions.Primary;
import com.github.zxhtom.leetcode.d1334.D1334;

import java.util.*;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/15
 */
public class D1334Impl implements D1334 {
    @Primary
    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[0]).add(new int[]{edge[1], edge[2]});
            edgeMap.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int[] distances = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[i] = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
            queue.add(new int[]{i, 0});
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int v = node[0], w = node[1];
                for (int[] nexts : edgeMap.getOrDefault(v, new ArrayList<>())) {
                    int next = nexts[0], nw = nexts[1];
                    if (distances[next] > w + nw) {
                        distances[next] = w + nw;
                        if (w + nw > distanceThreshold) {
                            continue;
                        }
                        queue.add(new int[]{next, w + nw});
                    }
                }
            }
            int count = (int) Arrays.stream(distances).filter(item -> item <= distanceThreshold).count();
            res[i] = count;
        }
        int min = Integer.MAX_VALUE;
        int resIndex = 0;
        for (int i = 0; i < res.length; i++) {
            if (min >= res[i]) {
                min = res[i];
                resIndex = i;
            }
        }
        return resIndex;
    }
}
