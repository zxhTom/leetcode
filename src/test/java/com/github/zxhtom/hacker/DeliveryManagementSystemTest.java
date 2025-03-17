package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.DeliveryManagementSystem.impl.DeliveryManagementSystem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/14
 */
public class DeliveryManagementSystemTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {1, 2},
                    {2, 3},
                    {2, 4}
            });
        }
    };
    List<Integer> ns = new ArrayList<Integer>(){
        {
            add(4);
        }
    };
    List<int[]> ans = new ArrayList<int[]>() {
        {
            add(new int[]{2, 3, 4});
        }
    };
    @Before
    public void initData(){

    }
    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            System.out.println("i = " + i);
            int[] ints = DeliveryManagementSystem.dijstraMap(ns.get(i), datas.get(i));
            boolean equals = Arrays.equals(ints, ans.get(i));
//            Assert.assertTrue(equals);
        }
    }
}
