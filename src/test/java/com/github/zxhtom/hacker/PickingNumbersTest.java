package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.PickingNumbers.impl.PickingNumbers;
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
public class PickingNumbersTest {
    List<List<Integer>> datas = new ArrayList<List<Integer>>(){
        {
            add(Arrays.asList(new Integer[]{4, 6, 5, 3, 3, 1}));
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
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            int res = PickingNumbers.pickingNumbers(datas.get(i));
            System.out.println("i = " + i);
            Assert.assertTrue(res == ans.get(i));
        }
    }
}
