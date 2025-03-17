package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.FormingAMagicSquare.impl.FormingAMagicSquare;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/9
 */
public class FormingAMagicSquareTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {6, 7, 8},
                    {7, 6, 2},
                    {3, 2, 3}
            });
            add(new int[][]{
                    {4, 5, 8},
                    {2, 4, 1},
                    {1, 9, 7}
            });

            add(new int[][]{
                    {5, 3, 4},
                    {1, 5, 8},
                    {6, 4, 2}
            });

            add(new int[][]{
                    {4, 9, 2},
                    {3, 5, 7},
                    {8, 1, 5}
            });

        }
    };

    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(17);
            add(14);
            add(7);
            add(1);
        }
    };

    @Before
    public void initData(){

    }
    @Test
    public void simpleTest(){
        for (int i = 0; i < datas.size(); i++) {
            int[][] array = datas.get(i);
            List<List<Integer>> list = Arrays.stream(array)
                    .map(row -> Arrays.stream(row)
                            .boxed() // 将 int 转换为 Integer
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());
            int j = FormingAMagicSquare.formingMagicSquare(list);
            System.out.println("i = " + i);
            Assert.assertTrue(j == ans.get(i));
        }
    }
}
