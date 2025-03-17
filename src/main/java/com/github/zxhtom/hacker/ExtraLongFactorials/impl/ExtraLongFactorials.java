package com.github.zxhtom.hacker.ExtraLongFactorials.impl;

import java.math.BigInteger;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/8
 */
public class ExtraLongFactorials {
    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger ans = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            ans=ans.multiply(BigInteger.valueOf(i + 1));
        }
        System.out.print(ans);
    }
}
