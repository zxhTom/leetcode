package com.github.zxhtom.hacker.Encryption.impl;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/12
 */
public class Encryption {
    public static String encryption(String s) {
        // Write your code here
        StringBuffer res = new StringBuffer();
        s = s.trim();
        int len = s.length();
        double sqrt = Math.sqrt(len);
        int floor = Double.valueOf(Math.floor(sqrt)).intValue();
        int ceil = Double.valueOf(Math.ceil(sqrt)).intValue();
        int min = Integer.MAX_VALUE;
        int row = 0;
        int col = 0;
        for (int i = floor; i<= ceil; i++) {
            for (int j = i; j<= ceil; j++) {
                int tmpArea = i*j;
                if (tmpArea < len) {
                    continue;
                }
                if (min > tmpArea) {
                    min = i * j;
                    row=i;
                    col = j;
                }
            }
        }
        char[][] datas = new char[row][col];
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                int ci = i * col + j;
                if (ci >= len) {
                    break;
                }
                datas[i][j] = s.charAt(ci);
            }
        }
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (datas[i][j] != '\u0000') {
                    res.append(datas[i][j] + "");
                }
            }
            res.append(" ");
        }
        return res.toString().substring(0,res.length()-1);
    }
}
