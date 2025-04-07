package com.github.zxhtom.leetcode.d139.impl;

import com.github.zxhtom.leetcode.d139.D139;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class D139_Dynamic_impl implements D139 {
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> collect = wordDict.stream().map(item -> item.length()).collect(Collectors.toSet());
        int len = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1);
        int[] dp = new int[len];
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            int start = node + 1;
            for (Integer step : collect) {
                if (start + step <= len && wordDict.contains(s.substring(start, start + step))) {
                    if (start + step == len) {
                        return true;
                    }
                    if (dp[start + step - 1] == 0) {
                        dp[start + step - 1] = 1;
                        queue.add(start + step - 1);
                    }
                }
            }
        }
        return false;
    }
}
