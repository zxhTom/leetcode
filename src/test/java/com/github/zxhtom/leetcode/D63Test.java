package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d63.D63;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D63Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {0, 0},
                    {0, 1}
            });
            add(new int[][]{
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            });
            add(new int[][]{
                    {0, 1},
                    {0, 0}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(0);
            add(2);
            add(1);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D63>> subTypesOf = getReflections().getSubTypesOf(D63.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D63> clazz : subTypesOf) {
                D63 leetcode = clazz.newInstance();
                int res = leetcode.uniquePathsWithObstacles(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
