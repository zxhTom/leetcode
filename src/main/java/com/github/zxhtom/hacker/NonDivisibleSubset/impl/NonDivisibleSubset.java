package com.github.zxhtom.hacker.NonDivisibleSubset.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/10
 */
public class NonDivisibleSubset {
    public static int maxSubsetSize(int k,List<Integer> s) {
        int maxSize = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer value : s) {
            value = value % k;
            map.putIfAbsent(value, 0);
            map.put(value,map.get(value) + 1);
        }
        for (int r = 0; r <= k / 2; r++) {
            if (r != 0 && r != (k - r)) {
                maxSize += Math.max(map.getOrDefault(r, 0), map.getOrDefault(k - r, 0));
            } else {
                maxSize += Math.min(map.getOrDefault(r, 0), 1);
            }
        }
        return maxSize;
    }
    public static int nonDivisibleSubset(int k, List<Integer> s) {
//        s=s.stream().map(item->item%k).collect(Collectors.toList());
        // Write your code here
//        s=s.stream().sorted().collect(Collectors.toList());
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            List<Integer> ans = new ArrayList<>();
            ans.add(s.get(i));
            for (int j = 0; j < s.size(); j++) {
                if (i == j) {
                    continue;
                }
                Integer needCheck = s.get(j);
                boolean match = true;
                for (Integer an : ans) {
                    long l = BigInteger.valueOf(an).add(BigInteger.valueOf(needCheck)).longValue();
                    long remainder = l % k;
                    if (BigDecimal.valueOf(remainder).subtract(BigDecimal.ZERO).intValue()==0) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    ans.add(needCheck);
                }
            }
            if (max < ans.size()) {
                max = ans.size();
            }
        }
        return maxSubsetSize(k, s);
    }
}
