package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d1027.D1027;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/8
 */
public class D1027Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>() {
        {
            add(new int[]{1, 0, 1, 0, 1, 1, 1});
            add(new int[]{3, 6, 9, 12});
            add(new int[]{9,4,7,2,10});
            add(new int[]{20,1,15,3,10,5,8});
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(5);
            add(4);
            add(3);
            add(4);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D1027> clazz : getSubTypesOf(D1027.class)) {
                D1027 leetcode = clazz.newInstance();
                int res = leetcode.longestArithSeqLength(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}

