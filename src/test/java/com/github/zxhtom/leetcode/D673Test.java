package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d673.D673;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D673Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>() {
        {
            add(new int[]{1, 3, 5, 4, 6, 9, 11, 10});
            add(new int[]{4, 4, 4, 4, 4});
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(4);
            add(5);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D673> clazz : getSubTypesOf(D673.class)) {
                D673 leetcode = clazz.newInstance();
                int res = leetcode.findNumberOfLIS(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
