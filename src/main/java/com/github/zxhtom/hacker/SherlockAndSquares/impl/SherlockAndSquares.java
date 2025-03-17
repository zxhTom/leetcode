package com.github.zxhtom.hacker.SherlockAndSquares.impl;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/8
 */
public class SherlockAndSquares {
    public static int squares(int a, int b) {
        // Write your code here
        int res = 0;
        if (b == 1) {
            return 1;
        }
        for (int i = 1; i <= b/2; i++) {
            int squares = i*i;
            if (a <= squares && squares <= b) {
                res++;
            }
            if (squares > b) {
                break;
            }
        }
        return res;
    }
}
