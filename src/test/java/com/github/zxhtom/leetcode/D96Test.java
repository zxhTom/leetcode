package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d96.D96;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D96Test extends BaseTest {
    List<Integer> datas = new ArrayList<Integer>(){
        {
            add(3);
            add(1);
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(5);
            add(1);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D96> clazz : getSubTypesOf(D96.class)) {
                D96 leetcode = clazz.newInstance();
                int res = leetcode.numTrees(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
