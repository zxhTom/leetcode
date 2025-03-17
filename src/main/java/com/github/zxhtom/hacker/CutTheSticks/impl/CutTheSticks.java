package com.github.zxhtom.hacker.CutTheSticks.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/9
 */
public class CutTheSticks {
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        while (arr.size() > 0) {
            ans.add(arr.size());
            Integer minValue = arr.stream().min(Comparator.naturalOrder()).get();
            arr = arr.stream().map(item -> item - minValue).filter(item -> item > 0).collect(Collectors.toList());
        }
        return ans;
    }
}
