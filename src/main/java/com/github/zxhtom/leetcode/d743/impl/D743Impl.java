package com.github.zxhtom.leetcode.d743.impl;


import com.github.zxhtom.leetcode.d743.D743;

import java.util.*;

public class D743Impl implements D743 {

    @Override
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(k);
        List<Integer> visited = new ArrayList<Integer>();
        Map<Integer, List<int[]>> map = new HashMap<Integer,List<int[]>>();
        for (int i = 0; i < times.length; i++) {
            List<int[]> orDefault = map.getOrDefault(times[i][0], new ArrayList<int[]>());
            orDefault.add(times[i]);
            map.put(times[i][0], orDefault);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[k-1] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<int[]> ints = map.getOrDefault(poll, new ArrayList<>());
            for (int[] anInt : ints) {
                int res = arr[poll-1] + anInt[2];
                if (arr[anInt[1]-1] > res) {
                    arr[anInt[1]-1] = res;
                    queue.add(anInt[1]);
                }
            }
        }
        int max = Arrays.stream(arr).max().getAsInt();
        if (max != Integer.MAX_VALUE) {
            return max;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        return -1;
    }
}
