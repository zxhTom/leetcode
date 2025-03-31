package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2607.D2607;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.Adler32;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/29
 */
public class D2607Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>() {
        {
            add(new int[]{2, 5, 5, 7});
            add(new int[]{1, 4, 1, 3});
        }
    };
    List<Integer> ks = new ArrayList<Integer>() {
        {
            add(3);
            add(2);
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
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
        Set<Class<? extends D2607>> subTypesOf = getReflections().getSubTypesOf(D2607.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2607> clazz : subTypesOf) {
                D2607 leetcode = clazz.newInstance();
                long res = leetcode.makeSubKSumEqual(datas.get(i), ks.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res - ans.get(i) == 0);
            }

        }
    }
}
