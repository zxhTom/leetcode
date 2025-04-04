package com.github.zxhtom.leetcode.d139.impl;

import com.github.zxhtom.leetcode.d139.D139;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class D139_Dynamic_impl implements D139 {
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> collect = wordDict.stream().map(item -> item.length()).collect(Collectors.toSet());
        return false;
    }
}
