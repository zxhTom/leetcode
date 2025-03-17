package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.CutTheSticks.impl.CutTheSticks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/9
 */
public class CutTheSticksTest {
    List<List<Integer>> datas = new ArrayList<List<Integer>>(){
        {
            add(Arrays.asList(new Integer[]{5, 4, 4, 2, 2, 8}));
        }
    };
    List<List<Integer>> ans = new ArrayList<List<Integer>>(){
        {
            add(Arrays.asList(new Integer[]{6, 4, 2, 1}));
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            List<Integer> integers = CutTheSticks.cutTheSticks(datas.get(i));
            System.out.println("i = " + i);
            Assert.assertTrue(Arrays.equals(integers.toArray(), ans.get(i).toArray()));
        }
    }
}
