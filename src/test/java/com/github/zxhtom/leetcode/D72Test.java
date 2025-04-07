package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d72.D72;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/5
 */
public class D72Test extends BaseTest {
    List<String[]> datas = new ArrayList<String[]>(){
        {
            add(new String[]{"pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"});
            add(new String[]{"", ""});
            add(new String[]{"horse", "ros"});
            add(new String[]{"intention", "execution"});
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(27);
            add(0);
            add(3);
            add(5);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D72> clazz : getSubTypesOf(D72.class)) {
                D72 leetcode = clazz.newInstance();
                int res = leetcode.minDistance(datas.get(i)[0], datas.get(i)[1]);
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
//                System.out.println("res = " + res);
            }
        }
    }
}
