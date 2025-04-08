package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d300.D300;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D300Test extends BaseTest {

    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{1, 3, 5, 4, 7});
            add(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(4);
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simipleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D300> clazz : getSubTypesOf(D300.class)) {
                D300 leetcode = clazz.newInstance();
                int res = leetcode.lengthOfLIS(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
