package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2466.D2466;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D2466Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{3, 2, 1, 1});
            add(new int[]{2, 3, 1, 2});
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(8);
            add(5);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2466> clazz : getSubTypesOf(D2466.class)) {
                D2466 leetcode = clazz.newInstance();
                int[] rows = datas.get(i);
                int res= leetcode.countGoodStrings(rows[0], rows[1], rows[2], rows[3]);
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
