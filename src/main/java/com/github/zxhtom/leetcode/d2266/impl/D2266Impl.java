package com.github.zxhtom.leetcode.d2266.impl;

import com.github.zxhtom.leetcode.d2266.D2266;

import java.util.Arrays;

public class D2266Impl implements D2266 {
    long[] commons ;
    long[] specials ;
    int MOD = 1000000007;
    @Override
    public int countTexts(String pressedKeys) {
        int length = pressedKeys.length();
        commons = new long[4>length+1?4:length+1];
        specials = new long[commons.length];
        Arrays.fill(commons, -1);
        Arrays.fill(specials, -1);
        commons[0] = 1;
        commons[1] = 1;
        commons[2] = 2;
        commons[3] = 4;
        specials[0] = 1;
        specials[1] = 1;
        specials[2] = 2;
        specials[3] = 4;
        int cnt = 0;
        long preTotal = 1;
        for (int i = 0; i < pressedKeys.length(); i++) {
            cnt++;
            char cc = pressedKeys.charAt(i);
            if (i == pressedKeys.length() - 1 || cc != pressedKeys.charAt(i + 1)) {
                preTotal = (preTotal * dfs(cc == '7' || cc == '9' ? 4 : 3, cnt)) % MOD;
                cnt = 0;
            }
        }
        return (int) preTotal;
    }

    private long dfs(int cross,int cnt) {
        if (cross == 4) {
            if (specials[cnt] != -1) {
                return specials[cnt];
            }
            return specials[cnt] = (dfs(cross,cnt - 1) + dfs(cross,cnt - 2) + dfs(cross,cnt - 3) + dfs(cross,cnt - 4))%MOD;
        } else {
            if (commons[cnt] != -1) {
                return commons[cnt];
            }
            return commons[cnt] = (dfs(cross,cnt - 1) + dfs(cross,cnt - 2) + dfs(cross,cnt - 3))%MOD;
        }
    }
}
