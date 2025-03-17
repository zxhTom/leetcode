package com.github.zxhtom.hacker.FormingAMagicSquare.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/9
 */
public class FormingAMagicSquare {
    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int n = s.size() * s.size();
        int midilleValue = (1 + n) / 2;
        int midilleIndex = s.size() / 2;
        List<Integer> ansList = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                int extracted = extracted(s, n, j, i, midilleValue, midilleIndex,1);
                int extracted1 = extracted(s, n, j, i, midilleValue, midilleIndex,-1);
                ansList.add(extracted);
                ansList.add(extracted1);
            }
        }
        return ansList.stream().min(Comparator.naturalOrder()).get();
    }

    private static int extracted(List<List<Integer>> s,  int n, int vertical, int horizontal, int midilleValue, int midilleIndex,int direction) {
        int ans = 0;
        int times = 0;
        int starti = midilleIndex;
        int startj = midilleIndex;
        while (times < n) {
            int nexti=(s.size() + starti + horizontal) % s.size();
            int nextj = (s.size() + startj + vertical) % s.size();
            if ((midilleValue + times) % s.size() == 0) {
                if (direction < 0) {
                    nexti = starti;
                    nextj = (s.size() + startj - vertical) % s.size();
                } else  {
                    nextj = startj;
                    nexti = (s.size() + starti - horizontal) % s.size();
                }
            }
            Integer integer = s.get(nexti).get(nextj);
            starti=nexti;
            startj=nextj;
            times++;
            ans += Math.abs(integer - ((midilleValue + times - 1) % n + 1));
        }
        return ans;
    }
}
