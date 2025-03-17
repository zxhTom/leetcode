package com.github.zxhtom.leetcode;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/20
 */
public class Leetcode509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int result =0;
        int[] total = new int[n+1];
        total[0]=0;
        total[1]=1;
        for (int i = 2; i <= n; i++) {
            total[i] = total[i - 1] + total[i - 2];
        }
        return total[n];
    }
}
