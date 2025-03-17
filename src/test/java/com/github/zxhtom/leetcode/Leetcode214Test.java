package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode214;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/25
 */
public class Leetcode214Test {
    private List<String> testDataList = new ArrayList<>();
    private List<String> resultList = new ArrayList<>();

    @Before
    public void init(){
        testDataList.add("aacecaaa");
        resultList.add("aaacecaaa");
        testDataList.add("abcd");
        resultList.add("dcbabcd");
        testDataList.add("");
        resultList.add("");
        testDataList.add("abbacd");
        resultList.add("dcabbacd");
    }

    @Test
    public void test() {
        Leetcode214 leetcode = new Leetcode214();
        for (int i = 0; i < testDataList.size(); i++) {
            String testData = testDataList.get(i);
            String res = leetcode.shortestPalindrome(testData);
            Assert.assertEquals(resultList.get(i), res);
        }
    }
}
