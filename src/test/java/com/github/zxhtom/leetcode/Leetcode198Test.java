package com.github.zxhtom.leetcode;

import com.github.zxhtom.leetcode.Leetcode198;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/22
 */
public class Leetcode198Test {
    private List<String> testData = new ArrayList<>();
    private List<Integer> resultData = new ArrayList<>();

    @Before
    public void init(){
        testData.add("1,2,3,1");
        resultData.add(4);
        testData.add("2,7,9,3,1");
        resultData.add(12);
        testData.add("0");
        resultData.add(0);
        testData.add("1,3,1,3,100");
        resultData.add(103);
    }

    @Test
    public void test() {
        Leetcode198 leetcode = new Leetcode198();
        for (int j = 0; j < testData.size(); j++) {
            String testDatum = testData.get(j);
            String[] split = testDatum.split(",");
            int[] realTestDatas = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                realTestDatas[i] = Integer.parseInt(split[i]);
            }
            int rob = leetcode.rob(realTestDatas);
            Assert.assertEquals(resultData.get(j), Integer.valueOf(rob));
        }
    }
}
