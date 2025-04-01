package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d120.D120;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class D120Test extends BaseTest {
    List<List<List<Integer>>> datas = new ArrayList<List<List<Integer>>>(){
        {
            add(Arrays.asList(Arrays.asList(-1), Arrays.asList(2, 3), Arrays.asList(1, -1, -3)));
            add(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(-1);
            add(11);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D120>> subTypesOf = getSubTypesOf(D120.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D120> clazz : subTypesOf) {
                D120 leetcode = clazz.newInstance();
                int res = leetcode.minimumTotal(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
