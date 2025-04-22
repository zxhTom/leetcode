package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d474.D474;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class D474Test extends BaseTest {
    List<String[]> datas1 = new ArrayList<String[]>() {
        {
            add(new String[]{"101000000", "1100001010", "11101000", "011010110", "0010001", "0011", "0111101111"});
            add(new String[]{"00", "000"});
            add(new String[]{"10", "0001", "111001", "1", "0"});
            add(new String[]{"10", "0001", "111001", "1", "0"});
            add(new String[]{"10", "0", "1"});
        }
    };
    List<Integer> ms = new ArrayList<Integer>(){
        {
            add(10);
            add(1);
            add(4);
            add(5);
            add(1);
        }
    };

    List<Integer> ns = new ArrayList<Integer>(){
        {
            add(11);
            add(10);
            add(3);
            add(3);
            add(1);
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(3);
            add(0);
            add(3);
            add(4);
            add(2);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < datas1.size(); i++) {
            for (Class<? extends D474> clazz : getSubTypesOf(D474.class)) {
                D474 leetcode = clazz.newInstance();
                int res = leetcode.findMaxForm(datas1.get(i), ms.get(i), ns.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(res == ans.get(i));
            }
        }
    }
}
