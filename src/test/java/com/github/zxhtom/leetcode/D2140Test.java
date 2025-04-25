package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2140.D2140;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D2140Test extends BaseTest {
    private List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {20, 4}, {78, 2}, {74, 1}, {48, 1}, {38, 1}, {80, 3}
            });

            add(new int[][]{
                    {21, 5}, {92, 3}, {74, 2}, {39, 4}, {58, 2}, {5, 5}, {49, 4}, {65, 3}
            });
            add(new int[][]{
                    {12, 46}, {78, 19}, {63, 15}, {79, 62}, {13, 10}
            });
            add(new int[][]{
                    {3, 2},
                    {4, 3},
                    {4, 4},
                    {2, 5}
            });
            add(new int[][]{
                    {1, 1},
                    {2, 2},
                    {3, 3},
                    {4, 4},
                    {5, 5}
            });
        }
    };
    private List<Long> ans = new ArrayList<Long>(){
        {
            add(158L);
            add(157L);
            add(79L);
            add(5L);
            add(7L);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2140> clazz : getSubTypesOf(D2140.class)) {
                D2140 leetcode = clazz.newInstance();
                long res = leetcode.mostPoints(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res - ans.get(i) == 0);
            }
        }
    }
}
