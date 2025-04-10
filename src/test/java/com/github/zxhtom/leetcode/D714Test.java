package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d714.D714;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D714Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{1,3,2,8,4,9});
            add(new int[]{1,3,7,5,10,3});
        }
    };
    List<Integer> pees = new ArrayList<Integer>(){
        {
            add(2);
            add(3);
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(8);
            add(6);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D714> clazz : getSubTypesOf(D714.class)) {
                D714 leetcode = clazz.newInstance();
                int res = leetcode.maxProfit(datas.get(i), pees.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
