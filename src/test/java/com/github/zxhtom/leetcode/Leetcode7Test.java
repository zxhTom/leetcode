package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode7;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/18
 */
public class Leetcode7Test {
    List<Integer> testData = new ArrayList<>();
    List<Integer> resultData = new ArrayList<>();

    Leetcode7 leetcode = new Leetcode7();

    @Before
    public void initTestData() {

        testData.add(123);
        resultData.add(321);
        testData.add(-123);
        resultData.add(-321);
        testData.add(120);
        resultData.add(21);
        testData.add(0);
        resultData.add(0);
        testData.add(1534236469);
        resultData.add(0);
        testData.add(2147483647);
        resultData.add(0);
    }
    @Test
    public void test(){

        for (int i = 0; i < testData.size(); i++) {
            int reverse = leetcode.reverse(testData.get(i));
            Assert.assertEquals(resultData.get(i), Integer.valueOf(reverse));
        }
    }
}
