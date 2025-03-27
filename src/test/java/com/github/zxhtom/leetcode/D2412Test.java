package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2412.D2412;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D2412Test extends BaseTest {
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
    @Before
    public void initData() {
        
    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D2412>> subTypesOf = getReflections().getSubTypesOf(D2412.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2412> clazz : subTypesOf) {
                D2412 leetcode = clazz.newInstance();
                long res = leetcode.minimumMoney(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
