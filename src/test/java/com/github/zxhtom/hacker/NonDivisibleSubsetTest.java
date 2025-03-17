package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.NonDivisibleSubset.impl.NonDivisibleSubset;
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
 * 2025/3/10
 */
public class NonDivisibleSubsetTest {
    List<int[][]> datas = new ArrayList<int[][]>(){
        {
            add(new int[][]{
                    {9},
                    {61197933, 56459859, 319018589, 271720536, 358582070, 849720202, 481165658, 675266245, 541667092, 615618805, 129027583, 755570852, 437001718, 86763458, 791564527, 163795318, 981341013, 516958303, 592324531, 611671866, 157795445, 718701842, 773810960, 72800260, 281252802, 404319361, 757224413, 682600363, 606641861, 986674925, 176725535, 256166138, 827035972, 124896145, 37969090, 136814243, 274957936, 980688849, 293456190, 141209943, 346065260, 550594766, 132159011, 491368651, 3772767, 131852400, 633124868, 148168785, 339205816, 705527969, 551343090, 824338597, 241776176, 286091680, 919941899, 728704934, 37548669, 513249437, 888944501, 239457900, 977532594, 140391002, 260004333, 911069927, 586821751, 113740158, 370372870, 97014913, 28011421, 489017248, 492953261, 73530695, 27277034, 570013262, 81306939, 519086053, 993680429, 599609256, 639477062, 677313848, 950497430, 672417749, 266140123, 601572332, 273157042, 777834449, 123586826}
            });
            add(new int[][]{
                    {9},
                    {422346306, 940894801, 696810740, 862741861, 85835055, 313720373}
            });
            add(new int[][]{
                    {4},
                    {19, 10, 12, 10, 24, 25, 22}
            });
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(50);
            add(5);
            add(3);
        }
    };
    @Before
    public void initData(){}
    @Test
    public void simpleTest(){
        for (int i = 0; i < datas.size(); i++) {
            int res = NonDivisibleSubset.nonDivisibleSubset(datas.get(i)[0][0], Arrays.stream(datas.get(i)[1]).boxed().collect(Collectors.toList()));
            System.out.println("i = " + i);
            Assert.assertTrue(res == ans.get(i));
        }
    }
}

