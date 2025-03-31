package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d740.D740;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/30
 */
public class D740Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>() {
        {
            add(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6});
            add(new int[]{8, 10, 4, 9, 1, 3, 5, 9, 4, 10});
            add(new int[]{3, 1});
            add(new int[]{3, 4, 2});
            add(new int[]{2, 2, 3, 3, 3, 4});
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(18);
            add(37);
            add(4);
            add(6);
            add(9);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D740>> subTypesOf = getReflections().getSubTypesOf(D740.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D740> clazz : subTypesOf) {
                D740 leetcode = clazz.newInstance();
                int res = leetcode.deleteAndEarn(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
