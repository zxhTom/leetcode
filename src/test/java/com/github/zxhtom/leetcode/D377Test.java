package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d377.D377;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/13
 */
public class D377Test extends BaseTest {

    List<int[]> datas1 = new ArrayList<int[]>(){
        {
            add(new int[]{1, 2, 3});
            add(new int[]{9});
        }
    };
    List<Integer> datas2 = new ArrayList<Integer>() {
        {
            add(4);
            add(3);
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(7);
            add(0);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas1.size(); i++) {
            for (Class<? extends D377> clazz : getSubTypesOf(D377.class)) {
                D377 leetcode = clazz.newInstance();
                int res = leetcode.combinationSum4(datas1.get(i), datas2.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
