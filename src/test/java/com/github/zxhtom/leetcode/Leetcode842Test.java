package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode842;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/20
 */
@Slf4j
public class Leetcode842Test {
    private List<String> testData = new ArrayList<>();
    private List<List<Integer>> resultData = new ArrayList<>();

    @Before
    public void init() {
        testData.add("112358130");
        testData.add("1101111");
        testData.add("0123");
        testData.add("1011");
        testData.add("5511816597");
    }

    @Test
    public void test() {
        Leetcode842 leetcode = new Leetcode842();
        for (String testDatum : testData) {
            List<Integer> res = leetcode.splitIntoFibonacci(testDatum);
            log.info("{}\nres={}", testDatum, res);
            for (int i = 2; i < res.size(); i++) {
                Integer except = res.get(i - 1) + res.get(i - 2);
                Assert.assertEquals(except, res.get(i));
            }
        }
    }
}
