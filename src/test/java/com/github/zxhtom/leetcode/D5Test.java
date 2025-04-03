package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d5.D5;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D5Test extends BaseTest {
    List<String> datas = new ArrayList<String>() {
        {
            add("babad");
            add("cbbd");
        }
    };
    List<String> ans = new ArrayList<String>() {
        {
            add("bab");
            add("bb");
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D5> clazz : getSubTypesOf(D5.class)) {
                D5 leetcode = clazz.newInstance();
                String res = leetcode.longestPalindrome(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(ans.get(i).equals(res));
            }
        }
    }
}
