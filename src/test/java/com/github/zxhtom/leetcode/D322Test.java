package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d322.D322;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D322Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{1,2147483647});
            add(new int[]{186, 419, 83, 408});
            add(new int[]{1,2,5});
            add(new int[]{2});
            add(new int[]{1});
        }
    };
    List<Integer> datas2 = new ArrayList<Integer>(){
        {
            add(2);
            add(6249);
            add(11);
            add(3);
            add(0);
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(2);
            add(20);
            add(3);
            add(-1);
            add(0);
        }
    };

    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D322> clazz : getSubTypesOf(D322.class)) {
                D322 leetcode = clazz.newInstance();
                int res = leetcode.coinChange(datas.get(i), datas2.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
