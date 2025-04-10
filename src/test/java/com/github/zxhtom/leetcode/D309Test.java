package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d309.D309;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D309Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{1, 2, 3, 0, 2});
            add(new int[]{1});
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(3);
            add(0);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D309> clazz : getSubTypesOf(D309.class)) {
                D309 leetcode = clazz.newInstance();
                int res = leetcode.maxProfit(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
