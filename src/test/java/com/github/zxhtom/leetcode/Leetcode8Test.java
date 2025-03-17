package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode8;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/19
 */
public class Leetcode8Test {
    private List<String> testData = new ArrayList<>();
    private List<Integer> resultData = new ArrayList<>();

    @Before
    public void initData(){
        testData.add("42");
        resultData.add(42);
        testData.add("   -42");
        resultData.add(-42);
        testData.add("4193 with words");
        resultData.add(4193);
        testData.add("+1");
        resultData.add(1);
        testData.add("+-12");
        resultData.add(0);
    }

    @Test
    public void test() {
        Leetcode8 leetcode = new Leetcode8();
        for (int i = 0; i < testData.size(); i++) {
            int res = leetcode.myAtoi(testData.get(i));
            Assert.assertEquals(resultData.get(i), Integer.valueOf(res));
            int j = leetcode.myAtoiOffice(testData.get(i));
            Assert.assertEquals(resultData.get(i), Integer.valueOf(j));
        }
    }

}
