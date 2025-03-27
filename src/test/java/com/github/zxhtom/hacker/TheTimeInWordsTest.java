package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.TheTimeInWords.impl.TheTimeInWords;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/26
 */
public class TheTimeInWordsTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{1, 1});
            add(new int[]{5, 47});
            add(new int[]{3, 0});
        }
    };
    List<String> ans = new ArrayList<String>(){
        {
            add("one minute past one");
            add("thirteen minutes to six");
            add("three o' clock");
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            String s = TheTimeInWords.timeInWords(datas.get(i)[0], datas.get(i)[1]);
            System.out.println("i = " + i);
            Assert.assertTrue(s.equals(ans.get(i)));

        }
    }
}
