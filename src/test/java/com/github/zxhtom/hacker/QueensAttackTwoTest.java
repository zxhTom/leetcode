package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.QueensAttackTwo.impl.QueensAttackTwo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/12
 */
public class QueensAttackTwoTest {
    private List<int[]> datas = new ArrayList<int[]>() {
        {
            add(new int[]{100000, 0, 4187, 5068});
            add(new int[]{4, 0, 4, 4});
            add(new int[]{5, 3, 4, 3});
        }
    };
    private List<int[][]> obstacleList = new ArrayList<int[][]>(){
        {
            add(new int[][]{});
            add(new int[][]{});
            add(new int[][]{
                    {5, 5},
                    {4, 2},
                    {2, 3}
            });
        }
    };
    private List<Integer> ans = new ArrayList<Integer>() {
        {
            add(308369);
            add(9);
            add(10);
        }
    };

    @Before
    public void initData() {

    }

    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            int[] positionarr = datas.get(i);
            int[][] ints = obstacleList.get(i);
            List<List<Integer>> collect = Arrays.stream(ints).map(row -> IntStream.of(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());
            int res = QueensAttackTwo.queensAttack(positionarr[0], positionarr[1], positionarr[2], positionarr[3], collect);
            System.out.println("i = " + i);
            Assert.assertTrue(res == ans.get(i));
        }
    }
}
