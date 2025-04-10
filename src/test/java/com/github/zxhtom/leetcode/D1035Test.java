package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d1035.D1035;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D1035Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>() {
        {
            add(new int[][]{
                    {1, 4, 2},
                    {1, 2, 4},
            });
            add(new int[][]{
                    {2, 5, 1, 2, 5},
                    {10, 5, 2, 1, 5, 2},
            });
            add(new int[][]{
                    {1, 3, 7, 1, 7, 5},
                    {1, 9, 2, 5, 1}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(2);
            add(3);
            add(2);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D1035> clazz : getSubTypesOf(D1035.class)) {
                D1035 leetcode = clazz.newInstance();
                int res = leetcode.maxUncrossedLines(datas.get(i)[0], datas.get(i)[1]);
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
