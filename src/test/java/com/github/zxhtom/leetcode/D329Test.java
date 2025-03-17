package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d329.D329;
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
 * 2025/3/17
 */
public class D329Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>() {
        {
            add(new int[][]{
                    {9, 9, 4},
                    {6, 6, 8},
                    {2, 1, 1}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D329>> subTypesOf = getReflections().getSubTypesOf(D329.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D329> clazz : subTypesOf) {
                D329 leetcode = clazz.newInstance();
                int res = leetcode.longestIncreasingPath(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
