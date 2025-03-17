package com.github.zxhtom.hacker.PickingNumbers.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/9
 */
public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int[] mid = new int[100];
        for (Integer integer : a) {
            mid[integer]++;
        }
        int[] sum = new int[100];
        for (int i = 1; i < mid.length; i++) {
            sum[i - 1] = mid[i] + mid[i - 1];
        }
        return Arrays.stream(sum).max().getAsInt();
    }
}
