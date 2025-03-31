package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2266.D2266;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D2266Test extends BaseTest {
    List<String> datas = new ArrayList<String>(){
        {
            add("999999999999");
            add("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664");
            add("2");
            add("22233");
            add("222222222222222222222222222222222222");
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(1490);
            add(537551452);
            add(1);
            add(8);
            add(82876089);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D2266>> subTypesOf = getReflections().getSubTypesOf(D2266.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2266> clazz : subTypesOf) {
                D2266 leetcode = clazz.newInstance();
                int res = leetcode.countTexts(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
