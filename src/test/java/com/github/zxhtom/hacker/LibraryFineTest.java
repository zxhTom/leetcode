package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.LibraryFine.impl.LibraryFine;
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
public class LibraryFineTest {
    List<int[]> datas = new ArrayList<int[]>(){
        {
            add(new int[]{14, 7, 2018, 5, 7, 2018});
            add(new int[]{9, 6, 2015, 6, 6, 2015});
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(135);
            add(45);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            int[] ints = datas.get(i);
            int res = LibraryFine.libraryFine(ints[0], ints[1], ints[2], ints[3], ints[4], ints[5]);
            System.out.println("i = " + i);
            Assert.assertTrue(res == ans.get(i));
        }
    }
}
