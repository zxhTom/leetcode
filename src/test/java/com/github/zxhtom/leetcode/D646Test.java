package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d646.D646;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D646Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>() {
        {
            add(new int[][]{
                    {-10, -8},
                    {8, 9},
                    {-5, 0},
                    {6, 10},
                    {-6, -4},
                    {1, 7},
                    {9, 10},
                    {-4, 7}
            });
            add(new int[][]{
                    {3, 4},
                    {2, 3},
                    {1, 2}
            });
            add(new int[][]{
                    {1, 2},
                    {2, 3},
                    {3, 4}}
            );
            add(new int[][]{
                    {1, 2},
                    {7, 8},
                    {4, 5}}
            );
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(4);
            add(2);
            add(2);
            add(3);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D646> clazz : getSubTypesOf(D646.class)) {
                D646 leetcode = clazz.newInstance();
                int res = leetcode.findLongestChain(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
