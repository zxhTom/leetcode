package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d1976.D1976;
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
public class D1976Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {3, 0, 4},
                    {0, 2, 3},
                    {1, 2, 2},
                    {4, 1, 3},
                    {2, 5, 5},
                    {2, 3, 1},
                    {0, 4, 1},
                    {2, 4, 6},
                    {4, 3, 1}

            });
            add(new int[][]{
                    {1, 0, 2348},
                    {2, 1, 2852},
                    {2, 0, 5200},
                    {3, 1, 12480},
                    {2, 3, 9628},
                    {4, 3, 7367},
                    {4, 0, 22195},
                    {5, 4, 5668},
                    {1, 5, 25515},
                    {0, 5, 27863},
                    {6, 5, 836},
                    {6, 0, 28699},
                    {2, 6, 23499},
                    {6, 3, 13871},
                    {1, 6, 26351},
                    {5, 7, 6229},
                    {2, 7, 28892},
                    {1, 7, 31744},
                    {3, 7, 19264},
                    {6, 7, 5393},
                    {2, 8, 31998},
                    {8, 7, 3106},
                    {3, 8, 22370},
                    {8, 4, 15003},
                    {8, 6, 8499},
                    {8, 5, 9335},
                    {8, 9, 5258},
                    {9, 2, 37256},
                    {3, 9, 27628},
                    {7, 9, 8364},
                    {1, 9, 40108},
                    {9, 5, 14593},
                    {2, 10, 45922},
                    {5, 10, 23259},
                    {9, 10, 8666},
                    {10, 0, 51122},
                    {10, 3, 36294},
                    {10, 4, 28927},
                    {11, 4, 25190},
                    {11, 9, 4929},
                    {11, 8, 10187},
                    {11, 6, 18686},
                    {2, 11, 42185},
                    {11, 3, 32557},
                    {1, 11, 45037}
            });
            add(new int[][]{
                    {0, 6, 7},
                    {0, 1, 2},
                    {1, 2, 3},
                    {1, 3, 3},
                    {6, 3, 3},
                    {3, 5, 1},
                    {6, 5, 1},
                    {2, 5, 1},
                    {0, 4, 5},
                    {4, 6, 2}
            });
        }
    };
    List<Integer> ns = new ArrayList<Integer>(){
        {
            add(6);
            add(12);
            add(7);
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(2);
            add(166);
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D1976>> subTypesOf = getReflections().getSubTypesOf(D1976.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D1976> clazz : subTypesOf) {
                D1976 leetcode = clazz.newInstance();
                int res = leetcode.countPaths(ns.get(i), datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
