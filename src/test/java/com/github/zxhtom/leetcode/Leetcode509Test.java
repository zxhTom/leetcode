package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode509;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zxhtom
 * 2023/12/20
 */
@Slf4j
public class Leetcode509Test {
    private List<Integer> testData = new ArrayList<>();
    private List<Integer> resultData = new ArrayList<>();
    @Before
    public void init() {
        testData.add(2);
        resultData.add(1);
        testData.add(3);
        resultData.add(2);
        testData.add(4);
        resultData.add(3);
        testData.add(0);
        resultData.add(0);
        testData.add(1);
        resultData.add(1);
    }
    @Test
    public void test() {
        Leetcode509 leetcode = new Leetcode509();
        for (int i = 0; i < testData.size(); i++) {
            Integer testDatum = testData.get(i);
            int fib = leetcode.fib(testDatum);
            log.info("{}...{}",resultData.get(i),testDatum);
            Assert.assertEquals(resultData.get(i), Integer.valueOf(fib));
        }
    }
}
