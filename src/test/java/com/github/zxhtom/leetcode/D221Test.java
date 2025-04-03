package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d221.D221;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D221Test extends BaseTest {
    List<char[][]> datas = new ArrayList<char[][]>(){
        {
            add(new char[][]{
                    {'0', '0', '0', '1'},
                    {'1', '1', '0', '1'},
                    {'1', '1', '1', '1'},
                    {'0', '1', '1', '1'},
                    {'0', '1', '1', '1'}
            });
            add(new char[][]{
                    {'0'},
                    {'1'}
            });
            add(new char[][]{
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '1', '1', '1'}
            });
            add(new char[][]{
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(9);
            add(1);
            add(16);
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D221> clazz : getSubTypesOf(D221.class)) {
                D221 leetcode = clazz.newInstance();
                int res = leetcode.maximalSquare(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
