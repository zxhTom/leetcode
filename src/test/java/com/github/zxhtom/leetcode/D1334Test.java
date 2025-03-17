package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d1334.D1334;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/15
 */
public class D1334Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {0, 1, 3},
                    {1, 2, 1},
                    {1, 3, 4},
                    {2, 3, 1}
            });
        }
    };
    List<Integer> ns = new ArrayList<Integer>() {
        {
            add(4);
        }
    };
    List<Integer> thresholds = new ArrayList<Integer>() {
        {
            add(4);
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(3);
        }
    };

    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D1334>> subTypesOf = getReflections().getSubTypesOf(D1334.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D1334> clazz : subTypesOf) {
                D1334 leetcode = clazz.newInstance();
                int theCity = leetcode.findTheCity(ns.get(i), datas.get(i), thresholds.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(theCity == ans.get(i));
            }
        }
    }
}
