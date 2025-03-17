package com.github.zxhtom.leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/25
 */
public class Leetcode214 {

    public static void main(String[] args) {
        String s = "aacecaaa";
        Leetcode214 leetcode214 = new Leetcode214();
        String s1 = leetcode214.shortestPalindromeKMP(s);
        System.out.println("s1 = " + s1);
    }
    public String shortestPalindromeKMP(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                best++;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        for (int i = s.length() - 1; i >= 1; i--) {
            String substring = s.substring(0, i + 1);
            String reverse = new StringBuffer(substring).reverse().toString();
            if (reverse.equals(substring)) {
                return new StringBuffer(s.substring(i + 1)).reverse() + s;
            }
        }
        return new StringBuffer(s.substring(1)).reverse().toString() + s;
    }
}
