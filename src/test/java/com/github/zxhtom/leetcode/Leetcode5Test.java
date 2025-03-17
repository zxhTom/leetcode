package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode5;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zxhtom
 * 2023/12/23
 */
@Slf4j
public class Leetcode5Test {
    private List<String> testData = new ArrayList<>();
    private List<List<String>> resultData = new ArrayList<>();

    @Before
    public void init() {
        testData.add("babad");
        resultData.add(new ArrayList<String>(){
            {
                add("bab");
                add("aba");
            }
        });
        testData.add("cbbd");
        resultData.add(new ArrayList<String>() {
            {
                add("bb");
            }
        });
        testData.add("a");
        resultData.add(new ArrayList<String>() {
            {
                add("a");
            }
        });
        testData.add("abb");
        resultData.add(new ArrayList<String>() {
            {
                add("bb");
            }
        });
        testData.add("eabcb");
        resultData.add(new ArrayList<String>() {
            {
                add("bcb");
            }
        });
    }


    @Test
    public void test() {
        Leetcode5 leetcode = new Leetcode5();
        for (int i = 0; i < testData.size(); i++) {
            String testDatum = testData.get(i);
            String res = leetcode.longestPalindrome(testDatum);
            log.info("{}...{}", testDatum, resultData.get(i));
            boolean contains = resultData.get(i).contains(res);
            Assert.assertTrue(contains);
        }
    }
}
