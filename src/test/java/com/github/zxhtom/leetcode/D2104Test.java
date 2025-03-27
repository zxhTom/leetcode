package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d2104.D2104;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/23
 */
public class D2104Test extends BaseTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{4, -2, -3, 4, 1});
            add(new int[]{1,3,3});
            add(new int[]{1,2,3});
        }
    };
    List<Long> ans = new ArrayList<Long>() {
        {
            add(59L);
            add(4L);
            add(4L);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D2104>> subTypesOf = getReflections().getSubTypesOf(D2104.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D2104> clazz : subTypesOf) {
                D2104 leetcode = clazz.newInstance();
                long l = leetcode.subArrayRanges(datas.get(i));
                System.out.println("i = " + i);
                Assert.assertTrue(BigDecimal.valueOf(l).subtract(BigDecimal.valueOf(ans.get(i))).intValue() == 0);
            }
        }
    }
}
