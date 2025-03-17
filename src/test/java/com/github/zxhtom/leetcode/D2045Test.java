package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2045.D2045;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D2045Test extends BaseTest {
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        List<int[][]> arrs = new ArrayList<int[][]>() {
            {
                add(new int[][]{
                        {1,2},
                        {1,3},
                        {2,4},
                        {3,5},
                        {5,4},
                        {4,6}
                });
                add(new int[][]{
                        {1, 2},
                        {1, 3},
                        {1, 4},
                        {3, 4},
                        {4, 5}});
                add(new int[][]{
                        {1, 2}
                });
                add(new int[][]{
                        {1, 2}
                });
            }
        };
        List<Integer> times = new ArrayList<Integer>() {
            {
                add(3);
                add(3);
                add(3);
                add(1);
            }
        };
        List<Integer> changes = new ArrayList<Integer>() {
            {
                add(100);
                add(5);
                add(2);
                add(2);
            }
        };
        List<Integer> ns = new ArrayList<Integer>() {
            {
                add(6);
                add(5);
                add(2);
                add(2);
            }
        };
        List<Integer> anss = new ArrayList<Integer>() {
            {
                add(12);
                add(13);
                add(11);
                add(5);
            }
        };
        Set<Class<? extends D2045>> subTypesOf = getReflections().getSubTypesOf(D2045.class);
        for (Class<? extends D2045> clazz : subTypesOf) {
            D2045 leetcode = clazz.newInstance();
            for (int i = 0; i < arrs.size(); i++) {
                int res = leetcode.secondMinimum(ns.get(i), arrs.get(i), times.get(i), changes.get(i));
                Assert.assertTrue(res == anss.get(i));
            }
        }
    }
}
