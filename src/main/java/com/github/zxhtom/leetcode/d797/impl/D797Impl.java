package com.github.zxhtom.leetcode.d797.impl;

import com.github.zxhtom.annotaions.Primary;
import com.github.zxhtom.leetcode.d797.D797;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zxhtom
 * 2025/3/15
 */
public class D797Impl implements D797 {

    @Primary
    @Override
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        dfs(resList, stack, graph, 0);
        return resList;
    }

    public void dfs(List<List<Integer>> list , Stack stack, int[][] graph , int cur) {
        if (cur == graph.length - 1) {
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i : graph[cur]) {
            stack.add(i);
            dfs(list, stack, graph, i);
            stack.pop();
        }
    }
    public List<List<Integer>> allPathsSourceTargetDijkstra(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        int[] visited = new int[graph.length];
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(0);
            }
        };
        resList.add(list);
        queue.add(list);
        while (!queue.isEmpty()) {
            List<Integer> nodeList = queue.poll();
            Integer lastNode = nodeList.get(nodeList.size() - 1);
            if (lastNode == graph.length - 1) {
                continue;
            }
            for (int i = 1; i < graph[lastNode].length; i++) {
                List<Integer> subList = new ArrayList<>(nodeList);
                subList.add(graph[lastNode][i]);
                resList.add(subList);
                queue.add(subList);
            }
            if (graph[lastNode].length > 0) {
                nodeList.add(graph[lastNode][0]);
                queue.add(nodeList);
            }
        }
        resList=resList.stream().filter(item->{
            return item.get(item.size() - 1) == graph.length - 1;
        }).collect(Collectors.toList());
        return resList;
    }
}
