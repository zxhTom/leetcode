package com.github.zxhtom.leetcode.d743.impl;


import com.github.zxhtom.leetcode.d743.D743;

import java.util.*;

public class D743StudyImpl implements D743 {
    class Node{
        Integer name;
        Integer distance;

        public Node(Integer name, Integer distance) {
            this.name = name;
            this.distance = distance;
        }
    }
    class DistanceNode{
        Integer name;
        Integer distance;
        public DistanceNode(Integer name, Integer distance) {
            this.name = name;
            this.distance = distance;
        }
    }
    @Override
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> dijMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int nodeName = times[i][0];
            dijMap.putIfAbsent(nodeName, new ArrayList<>());
            dijMap.get(nodeName).add(times[i]);
        }
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(k, 0));
        distanceMap.put(k, -1);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Integer nodeName = poll.name;
            Integer distance = poll.distance;
            List<int[]> orDefault = dijMap.getOrDefault(nodeName, new ArrayList<>());
            for (int[] ints : orDefault) {
                if (distance + ints[2] < distanceMap.getOrDefault(ints[1], Integer.MAX_VALUE)) {
                    distanceMap.put(ints[1], distance + ints[2]);
                    queue.add(new Node(ints[1], distance + ints[2]));
                }
            }
        }
        if (distanceMap.size() == 0) {
            return -1;
        }
        int maxDistance = Collections.max(distanceMap.values());
        if (Integer.MAX_VALUE != maxDistance) {
            return maxDistance;
        }
        return -1;
    }
}
