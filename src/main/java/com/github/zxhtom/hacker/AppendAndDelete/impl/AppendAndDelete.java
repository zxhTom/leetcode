package com.github.zxhtom.hacker.AppendAndDelete.impl;

/**
 * @author zxhtom
 * 2025/3/8
 */
public class AppendAndDelete {
    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int combineIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i < t.length()&&s.charAt(i)==t.charAt(i)) {
                combineIndex = i;
            }
            if (combineIndex != i) {
                break;
            }
        }
        combineIndex++;
        int minIndex = 0;
        minIndex += s.length() - combineIndex;
        minIndex += t.length() - combineIndex;
        int tmp = k-minIndex;
        if (tmp < 0) {
            return "No";
        }
        if (tmp==0||tmp%2==0||tmp >= combineIndex * 2) {
            return "Yes";
        }
        return "No";
    }
}
