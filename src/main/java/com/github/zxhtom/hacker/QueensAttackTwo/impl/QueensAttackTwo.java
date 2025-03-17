package com.github.zxhtom.hacker.QueensAttackTwo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/12
 */
public class QueensAttackTwo {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        Map<String, Integer> obstacleMap = new HashMap<>();
        for (List<Integer> obstacle : obstacles) {
            String key = String.format("%s_%s", obstacle.get(0), obstacle.get(1));
            obstacleMap.put(key, 1);
        }
        // zero equals false , one equals true
        int maxAttachCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == j && i == 0) {
                    continue;
                }
                int startRow = r_q + i;
                int startCol = c_q + j;
                while (startRow > 0 & startCol > 0 & startRow <= n && startCol <= n) {
                    String key = String.format("%s_%s", startRow, startCol);
                    if (obstacleMap.containsKey(key)) {
                       break;
                    }
                    maxAttachCount++;
                    startRow += i;
                    startCol += j;
                }
            }
        }
        return maxAttachCount;
    }
}
