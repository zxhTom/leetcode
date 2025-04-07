package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d712.D712;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D712Test extends BaseTest {
    List<String[]> datas = new ArrayList<String[]>() {
        {
            add(new String[]{"a", "at"});
            add(new String[]{"sea", "eat"});
            add(new String[]{"delete", "leet"});
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(116);
            add(231);
            add(403);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D712> clazz : getSubTypesOf(D712.class)) {
                D712 leetcode = clazz.newInstance();
                int res = leetcode.minimumDeleteSum(datas.get(i)[0], datas.get(i)[1]);
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
