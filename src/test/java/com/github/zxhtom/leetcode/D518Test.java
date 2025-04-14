package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d518.D518;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/12
 */
public class D518Test extends BaseTest {
    List<Integer> datas1 = new ArrayList<Integer>() {
        {
            add(10);
            add(5);
            add(3);
            add(10);
        }
    };
    List<int[]> datas2 = new ArrayList<int[]>(){
        {
            add(new int[]{5});
            add(new int[]{1, 2, 5});
            add(new int[]{2});
            add(new int[]{10});
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(1);
            add(4);
            add(0);
            add(1);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas1.size(); i++) {
            for (Class<? extends D518> clazz : getSubTypesOf(D518.class)) {
                D518 leetcode = clazz.newInstance();
                int res = leetcode.change(datas1.get(i), datas2.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
