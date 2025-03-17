package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2713.D2713;
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
public class D2713Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {3, 1},
                    {3, 4}
            });
            add(new int[][]{
                    {3, 8, -6}
            });
            add(new int[][]{
                    {-8, 4, 9, -1}
            });
            add(new int[][]{
                    {3, 1, 6},
                    {-9, 5, 7}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(2);
            add(3);
            add(4);
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D2713>> subTypesOf = getReflections().getSubTypesOf(D2713.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2713> clazz : subTypesOf) {
                D2713 leetcode = clazz.newInstance();
                int res = leetcode.maxIncreasingCells(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
        System.out.println(2 << 2);
    }
}
