package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.d1334.D1334;
import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D1334Test {
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        List<int[][]> edgesList = new ArrayList<int[][]>() {
            {
                add(new int[][]{
                        {0, 3, 7},
                        {2, 4, 1},
                        {0, 1, 5},
                        {2, 3, 10},
                        {1, 3, 6},
                        {1, 2, 1}
                });
                add(new int[][]{
                        {0, 1, 3},
                        {1, 2, 1},
                        {1, 3, 4},
                        {2, 3, 1}
                });
                add(new int[][]{
                        {0, 1, 2},
                        {0, 4, 8},
                        {1, 2, 3},
                        {1, 4, 2},
                        {2, 3, 1},
                        {3, 4, 1}
                });
            }
        };
        List<Integer> ns = new ArrayList<Integer>(){
            {
                add(6);
                add(4);
                add(5);
            }
        };
        List<Integer> distanceThresholds = new ArrayList<Integer>(){
            {
                add(417);
                add(4);
                add(2);
            }
        };
        List<Integer> anss = new ArrayList<Integer>(){
            {
                add(1);
                add(3);
                add(0);
            }
        };
        Reflections leetcodes = new Reflections("leetcodes");
        Set<Class<? extends D1334>> subTypesOf = leetcodes.getSubTypesOf(D1334.class);
        for (int i = 0; i < edgesList.size(); i++) {
            for (Class<? extends D1334> clazz : subTypesOf) {
                D1334 leetcode = clazz.newInstance();
                int theCity = leetcode.findTheCity(ns.get(i), edgesList.get(i), distanceThresholds.get(i));
                Assert.assertTrue(theCity == anss.get(i));
            }
        }
    }
}
