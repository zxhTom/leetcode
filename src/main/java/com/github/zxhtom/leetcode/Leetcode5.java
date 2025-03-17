package com.github.zxhtom.leetcode;

import javax.sound.midi.Track;
import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/23
 */
public class Leetcode5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int[][] dp = new int[length][length];
        char[] chars = s.toCharArray();
        dp[1][0] = chars[0] == chars[1] ? 1 : 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    if (i - j < 3) {
                        dp[i][j]= 1;
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j + 1];
                }
            }
        }
        int index =0;
        while (index < length) {
            for (int m = length - 1 - index; m < length; m++) {
                int rightM = m + index - (length-1);
                if (dp[m][rightM] == 1) {
                    return s.substring(rightM, m + 1);
                }
            }
            index++;
        }
        return "";
    }
}
