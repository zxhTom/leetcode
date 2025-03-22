package com.github.zxhtom.leetcode;

import java.util.ArrayList;
import java.util.List;

public class D2412Test {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {2, 1},
                    {5, 0},
                    {4, 2}
            });
            add(new int[][]{
                    {3, 0},
                    {0, 3}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(10);
            add(3);
        }
    };
}
