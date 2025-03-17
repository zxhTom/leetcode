package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2328.D2328;
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
 * 2025/3/16
 */
public class D2328Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>() {
        {
            add(new int[][]{
                    {1, 1},
                    {3, 4}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(8);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D2328>> subTypesOf = getReflections().getSubTypesOf(D2328.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2328> clazz : subTypesOf) {
                D2328 leetcode = clazz.newInstance();
                int res = leetcode.countPaths(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
