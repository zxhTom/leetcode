package com.github.zxhtom.hacker.BiggerIsGreater.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/14
 */
public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        // Write your code here
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] chars = w.toCharArray();
        for (int length = chars.length-1; length > 0; length--) {
            map.put(chars[length], length);
            if (map.firstKey() > chars[length - 1]) {
                Integer index = map.get(map.firstKey());
                char tmp = chars[index];
                chars[index] = chars[length - 1];
                chars[length - 1] = tmp;
                return new String(chars);
            }
        }
        return "no answer";
    }
}
