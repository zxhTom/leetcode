package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d797.D797;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/15
 */
public class D797Test extends BaseTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {2},
                    {},
                    {1}
            });

            add(new int[][]{
                    {4, 3, 1}, {3, 2, 4}, {}, {4}, {}
            });
            add(new int[][]{
                    {1, 2},
                    {3},
                    {3},
                    {}
            });
        }
    };
    List<int[][]> ans = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {0, 2}
            });
            add(new int[][]{
                    {0, 4}, {0, 3, 4}, {0, 1, 3, 4}, {0, 1, 4}
            });
            add(new int[][]{
                    {0, 1, 3},
                    {0, 2, 3}
            });
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D797>> classes = getReflections().getSubTypesOf(D797.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D797> clazz : classes) {
                D797 leetcode = clazz.newInstance();
                List<List<Integer>> lists = leetcode.allPathsSourceTarget(datas.get(i));
                int[][] ints = ans.get(i);
                List<List<Integer>> collect = Arrays.stream(ints).map(item -> Arrays.stream(item).boxed().collect(Collectors.toList())).collect(Collectors.toList());
                boolean flag = true;
                for (List<Integer> integers : collect) {
                    if (!lists.contains(integers)) {
                        flag=false;
                        break;
                    }
                }
                Assert.assertTrue(flag);
            }
        }
    }
}
