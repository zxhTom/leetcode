package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d139.D139;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D139Test extends BaseTest {
    List<String> datas = new ArrayList<String>(){
        {
            add("goalspecial");
            add("aaaaaaa");
            add("applepenapple");
            add("catsandog");
        }
    };
    List<List<String>> datas2 = new ArrayList<List<String>>(){
        {
            add(Arrays.asList(new String[]{"go","goal","goals","special"}));
            add(Arrays.asList(new String[]{"aaaa","aaa"}));
            add(Arrays.asList(new String[]{"apple", "pen"}));
            add(Arrays.asList(new String[]{"cats","dog","sand","and","cat"}));
        }
    };

    List<Boolean> ans = new ArrayList<Boolean>(){
        {
            add(true);
            add(true);
            add(true);
            add(false);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D139> clazz : getSubTypesOf(D139.class)) {
                D139 leetcode = clazz.newInstance();
                boolean res = leetcode.wordBreak(datas.get(i), datas2.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
