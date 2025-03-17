package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.OrganizingContainersOfBalls.impl.OrganizingContainersOfBalls;
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
public class OrganizingContainersOfBallsTest {
    enum RES{
        IMPOSSIBLE("Impossible")
        ,POSSIBLE("Possible");
        private String code ;

        private RES(String code) {
            this.code = code;
        }
    }
    List<int[][]> datas = new ArrayList<int[][]>() {
        {
            add(new int[][]{
                    {993263231, 806455183, 972467746, 761846174, 226680660, 667393859, 815298761, 790313908, 997845516},
                    {873142072, 579210472, 996344520, 999601755, 904458846, 663577990, 980240637, 713052540, 963408591},
                    {551159221, 873763794, 752756532, 798803609, 670921889, 995259612, 981339960, 763904498, 499472207},
                    {975980611, 999974039, 729219884, 834636710, 973988213, 969888254, 846967495, 687204298, 511348404},
                    {993232608, 998103218, 857820670, 995587240, 817798750, 773950980, 824882180, 797565274, 887424441},
                    {847857578, 768853671, 916073200, 982234748, 986511977, 733420232, 997714976, 819799716, 891570083},
                    {733197334, 985682497, 612123868, 971798655, 999905357, 710092446, 997494889, 683312998, 850074746},
                    {799093993, 543648222, 944524289, 814951921, 981087922, 997222915, 506561779, 997697933, 652807674},
                    {989362549, 973516812, 891706714, 786904549, 982329176, 376575034, 993535504, 984745483, 777613376}
            });
            add(new int[][]{
                    {46243313 ,92616295 ,67710591 ,64815435 ,54972858 ,72243452 ,43981963 ,98839842},
                    {92051933 ,89794374 ,13448199 ,23493279 ,82268795 ,11069706 ,82550576 ,19654929},
                    {81743395 ,56456242 ,80407875 ,99464396 ,95594850 ,44919631 ,12483256 ,54576390},
                    {31379865 ,35550507 ,13850344 ,82310457 ,35039216 ,11977132 ,44906966 ,58819635},
                    {10544893 ,81324309 ,69520528 ,81983330 ,45347555 ,78383273 ,77715274 ,86346533},
                    {78482611 ,37125744 ,47756688 ,70062813 ,86629089 ,81735741 ,38208033 ,80479682},
                    {59164275 ,5441347 ,85517562 ,78736923 ,59124243 ,51404960 ,24474089 ,27179427},
                    {48097170 ,61680833 ,13467922 ,1371525 ,59776803 ,85694885 ,96662368 ,52983154}
            });
            add(new int[][]{
                    {1, 3, 1},
                    {2, 1, 2},
                    {3, 3, 3}
            });
            add(new int[][]{
                    {0, 2, 1},
                    {1, 1, 1},
                    {2, 0, 0}
            });
        }
    };

    List<RES> ans = new ArrayList<RES>() {
        {
            add(RES.POSSIBLE);
            add(RES.IMPOSSIBLE);
            add(RES.IMPOSSIBLE);
            add(RES.POSSIBLE);
        }
    };
    @Before
    public void initData(){

    }
    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            List<List<Integer>> collect = Arrays.stream(datas.get(i)).map(row -> IntStream.of(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());
            String res = OrganizingContainersOfBalls.organizingContainers(collect);
            System.out.println("i = " + i);
            Assert.assertTrue(res.equals(ans.get(i).code));
        }
    }
}
