package com.github.zxhtom.leetcode.d96.impl;

import com.github.zxhtom.leetcode.d96.D96;

public class D96Impl implements D96 {
    @Override
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int j = 2; j <= n; j++) {
//            dp[j]=Double.valueOf(Math.pow(2,j)).intValue()+
        }
        return 0;
    }
}
