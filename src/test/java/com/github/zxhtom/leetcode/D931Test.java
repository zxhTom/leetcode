package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d931.D931;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D931Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {2, 1, 3},
                    {6, 5, 4},
                    {7, 8, 9}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(13);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D931> clazz : getSubTypesOf(D931.class)) {
                D931 leetcode = clazz.newInstance();
                int res = leetcode.minFallingPathSum(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
