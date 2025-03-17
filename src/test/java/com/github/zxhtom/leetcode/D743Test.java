package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d743.D743;
import org.junit.Test;

import java.util.Set;

public class D743Test extends BaseTest {
    @Test
    public void minJumps() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D743>> subTypesOf = getReflections().getSubTypesOf(D743.class);
        int[][] times = new int[][]{
                {1,2,1}
        };
        int n = 2;
        int k = 2;
        for (Class<? extends D743> clazz : subTypesOf) {
            D743 leetcode = clazz.newInstance();
            leetcode.networkDelayTime(times, n, k);
        }
    }
}
