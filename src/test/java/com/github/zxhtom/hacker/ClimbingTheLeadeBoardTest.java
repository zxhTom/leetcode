package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.ClimbingTheLeadBoard.impl.ClimbingTheLeadBoard;
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
public class ClimbingTheLeadeBoardTest {
    List<int[][]> datas = new ArrayList<int[][]>() {
        {
            add(new int[][]{
                    {100, 90, 90, 80, 75, 60},
                    {50, 65, 77, 90, 102}
            });
        }
    };
    List<int[]> ans = new ArrayList<int[]>(){
        {
            add(new int[]{6, 5, 4, 2, 1});
        }
    };
    @Before
    public void initData(){

    }
    @Test
    public void simpleTest(){
        for (int i = 0; i < datas.size(); i++) {
            int[][] ints = datas.get(i);
            List<Integer> rankedList = Arrays.stream(ints[0]).boxed().collect(Collectors.toList());
            List<Integer> playerList = Arrays.stream(ints[1]).boxed().collect(Collectors.toList());
            List<Integer> integers = ClimbingTheLeadBoard.climbingLeaderboard(rankedList, playerList);
            System.out.println("i = " + i);
            Assert.assertTrue(Arrays.equals(integers.toArray(), Arrays.stream(ans.get(i)).boxed().collect(Collectors.toList()).toArray()));
        }
    }

}
