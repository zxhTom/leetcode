package com.github.zxhtom.hacker.LibraryFine.impl;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/8
 */
public class LibraryFine {
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        int returns = Integer.valueOf(y1 + String.format("%02d", m1) + String.format("%02d", d1));
        int expects = Integer.valueOf(y2 + String.format("%02d", m2) + String.format("%02d", d2));
        if (returns <= expects) {
            return 0;
        }
        if (y1 > y2) {
            return 10000;
        } else if (m1 > m2) {
            return 500 * (m1 - m2);
        } else if (d1 > d2) {
            return 15 * (d1 - d2);
        }
        return 0;
    }
}
