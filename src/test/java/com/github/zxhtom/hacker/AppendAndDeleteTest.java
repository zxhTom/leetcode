package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.AppendAndDelete.impl.AppendAndDelete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/8
 */
public class AppendAndDeleteTest {
    List<String> firsts = new ArrayList<String>() {
        {
            add("asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv");
            add("hackerhappy");
            add("aba");
            add("ashley");
            add("y");
            add("aaaaaaaaaa");
            add("qwerasdf");
        }
    };
    List<String> seconds = new ArrayList<String>() {
        {
            add("bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv");
            add("hackerrank");
            add("aba");
            add("ash");
            add("yu");
            add("aaaaa");
            add("qwerbsdf");
        }
    };
    List<Integer> thirds = new ArrayList<Integer>() {
        {
            add(100);
            add(9);
            add(7);
            add(2);
            add(2);
            add(7);
            add(6);
        }
    };
    List<String> ans = new ArrayList<String>() {
        {
            add("No");
            add("Yes");
            add("Yes");
            add("No");
            add("No");
            add("Yes");
            add("No");
        }
    };
    @Before
    public void initData() {
    }
    @Test
    public void simpleTest() {
        PrintStream originalOut = System.out;
        for (int i = 0; i < firsts.size(); i++) {
            String s = AppendAndDelete.appendAndDelete(firsts.get(i), seconds.get(i), thirds.get(i));
            System.out.println("i = " + i);
            Assert.assertTrue(s.equals(ans.get(i)));
        }
    }
}
