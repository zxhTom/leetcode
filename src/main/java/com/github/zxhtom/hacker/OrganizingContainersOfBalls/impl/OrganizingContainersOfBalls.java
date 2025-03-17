package com.github.zxhtom.hacker.OrganizingContainersOfBalls.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/12
 */
public class OrganizingContainersOfBalls {
    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        String res = "Possible";
        List<Long> rowSumList = container.stream().map(item -> item.stream().collect(Collectors.summingLong(Integer::longValue))).sorted().collect(Collectors.toList());
        List<Long> colSumList = new ArrayList<>();
        for (int i = 0; i < container.size(); i++) {
            int finalI = i;
            Long collect = container.stream().map(item -> item.get(finalI)).collect(Collectors.summingLong(Integer::longValue));
            colSumList.add(collect);
        }
        colSumList=colSumList.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < colSumList.size(); i++) {
            if (BigDecimal.valueOf(rowSumList.get(i)).subtract(BigDecimal.valueOf(colSumList.get(i))).intValue()!=0) {
                return "Impossible";
            }
        }
        return res;
    }
}
