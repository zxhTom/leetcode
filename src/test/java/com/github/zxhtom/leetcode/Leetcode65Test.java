package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode65;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/19
 */
@Slf4j
public class Leetcode65Test {
    private List<String> testData = new ArrayList<>();
    private List<Boolean> resultData = new ArrayList<>();
    @Before
    public void init () {
        List<String> rightList = Arrays.asList(new String[]
        {
                "2", "0089",
                "-0.1", "+3.14",
                "4.", "-.9",
                "2e10", "-90E3",
                "3e+7", "+6e-1",
                "53.5e93", "-123.456e789"
        });

        List<String> errorList = Arrays.asList(new String[]
        {
                "abc", "1a",
                "1e", "e3",
                "99e2.5", "--6",
                "-+3", "95a54e53",
                ".",".e1","e","E","9E",
                "+.","-.","92e1740e91"
        });
        for (String right : rightList) {
            testData.add(right);
            resultData.add(true);
        }
        for (String error : errorList) {
            testData.add(error);
            resultData.add(false);
        }
    }

    @Test
    public void test() {
        Leetcode65 leetcode = new Leetcode65();
        for (int i = 0; i < testData.size(); i++) {
            String testDatum = testData.get(i);
            boolean number = leetcode.isNumber(testDatum);
            log.info("{}...{}", testDatum, resultData.get(i));
            Assert.assertEquals(resultData.get(i), number);
        }
    }
}
