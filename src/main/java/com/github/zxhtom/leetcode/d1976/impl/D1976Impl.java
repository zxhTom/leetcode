package com.github.zxhtom.leetcode.d1976.impl;

import com.github.zxhtom.annotaions.Primary;
import com.github.zxhtom.leetcode.d1976.D1976;
import org.w3c.dom.Node;

import java.nio.channels.ClosedSelectorException;
import java.util.*;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/15
 */
public class D1976Impl implements D1976 {
    @Primary
    @Override
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<int[]>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            edges[road[0]].add(new int[]{road[1], road[2]});
            edges[road[1]].add(new int[]{road[0], road[2]});
        }
        long[] distances = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distances,Long.MAX_VALUE);
        distances[0] = 0;
        ways[0] = 1;
//        Queue<long[]> queue = new LinkedList<>();

        PriorityQueue<long[]> queue = new PriorityQueue<long[]>((a, b) -> Long.compare(a[1], b[1]));
        queue.add(new long[]{0, 0});
        while (!queue.isEmpty()) {
            long[] node = queue.poll();
            int cn = (int) node[0];
            for (int[] nexts : edges[cn]) {
                if (distances[nexts[0]] > node[1] + nexts[1]) {
                    distances[nexts[0]] = node[1] + nexts[1];
                    ways[nexts[0]]=ways[cn];
                    if (nexts[0] == n - 1) {
                       continue;
                    }
                    queue.add(new long[]{nexts[0], node[1] + nexts[1]});
                } else if (distances[nexts[0]] == node[1] + nexts[1]) {
                    ways[nexts[0]] = (ways[nexts[0]] + ways[cn]) % mod;
                }
            }

        }
        return ways[n-1];
    }
}
