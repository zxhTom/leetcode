package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d279.D279;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/11
 */
public class D279Test extends BaseTest {
    List<Integer> datas = new ArrayList<Integer>(){
        {
            add(12);
            add(13);
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
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
            for (Class<? extends D279> clazz : getSubTypesOf(D279.class)) {
                D279 leetcode = clazz.newInstance();
                int res = leetcode.numSquares(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
