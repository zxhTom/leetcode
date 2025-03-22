package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d910.D910;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D910Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{1});
            add(new int[]{0,10});
            add(new int[]{1, 3, 6});
        }
    };
    List<Integer> datas2 = new ArrayList<Integer>(){
        {
            add(0);
            add(2);
            add(3);
        }
    };
    List<Integer> ants = new ArrayList<Integer>(){
        {
            add(0);
            add(6);
            add(3);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D910>> subTypesOf = getReflections().getSubTypesOf(D910.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D910> clazz : subTypesOf) {
                D910 leetcode = clazz.newInstance();
                int res = leetcode.smallestRangeII(datas.get(i), datas2.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ants.get(i));
            }
        }
    }
}
