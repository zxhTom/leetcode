package com.github.zxhtom.leetcode.d139.impl;

import com.github.zxhtom.annotaions.Ignore;
import com.github.zxhtom.leetcode.d139.D139;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * dijkstra algorithm will run timeout in leetcode environments
 * ignore it
 */
@Ignore
public class D139Impl implements D139 {
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = index + 1; i < len; i++) {
                if (wordDict.contains(s.substring(index + 1, i + 1))) {
                    queue.add(i);
                    if (i == len - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
