package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d1218.D1218;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D1218Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>() {
        {
            add(new int[]{3, 0, -3, 4, -4, 7, 6});
            add(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1});
            add(new int[]{1, 2, 3, 4});
            add(new int[]{1, 3, 5, 7});
            add(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1});
        }
    };
    List<Integer> datas2 = new ArrayList<Integer>(){
        {
            add(3);
            add(-2);
            add(1);
            add(1);
            add(-2);
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(2);
            add(4);
            add(4);
            add(1);
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D1218> clazz : getSubTypesOf(D1218.class)) {
                D1218 leetcode = clazz.newInstance();
                int res = leetcode.longestSubsequence(datas.get(i), datas2.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
