package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.SherlockAndSquares.impl.SherlockAndSquares;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/8
 */
public class SherlockAndSquaresTest {
    List<int[]> firsts = new ArrayList<int[]>() {
        {
            add(new int[]{3, 9});
            add(new int[]{17, 24});
            add(new int[]{35, 70});
            add(new int[]{100, 1000});
            add(new int[]{1, 1});
        }
    };
    List<Integer> ans = new ArrayList<Integer>() {
        {
            add(2);
            add(0);
            add(3);
            add(22);
            add(1);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest(){
        for (int i = 0; i < firsts.size(); i++) {
            System.out.println("i = " + i);
            int[] ints = firsts.get(i);
            int squares = SherlockAndSquares.squares(ints[0], ints[1]);
            Assert.assertTrue(squares == ans.get(i));
        }
    }
}
