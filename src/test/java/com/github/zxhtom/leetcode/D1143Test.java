package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d1143.D1143;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D1143Test extends BaseTest {
    List<String[]> datas = new ArrayList<String[]>(){
        {
            add(new String[]{"abcde", "ace"});
            add(new String[]{"abc", "abc"});
            add(new String[]{"abc", "def"});
        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(3);
            add(3);
            add(0);
        }
    };

    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D1143> clazz : getSubTypesOf(D1143.class)) {
                D1143 leetcode = clazz.newInstance();
                int res = leetcode.longestCommonSubsequence(datas.get(i)[0], datas.get(i)[1]);
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
