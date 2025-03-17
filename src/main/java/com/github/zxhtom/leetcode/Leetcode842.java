package com.github.zxhtom.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/20
 */
public class Leetcode842 {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        splitIntoFibonacciRoll(res, num);
        return res;
    }
    public List<Integer> splitIntoFibonacciRoll(List<Integer> res , String num) {
        boolean add =false;
        for (int i = 0; i < num.length(); i++) {
            if (i>0&&num.charAt(0) == '0') {
                continue;
            }
            if (i > 9) {
                continue;
            }
            if (i == 9) {
                Integer preInteger = Integer.valueOf(num.substring(0, i));
                if (preInteger > Integer.MAX_VALUE/10) {
                    continue;
                }
                if (preInteger == Integer.MAX_VALUE/10 && Integer.valueOf(num.substring(i, i + 1)) > 7) {
                    continue;
                }
            }
            Integer integer = Integer.valueOf(num.substring(0, i + 1));
            int size = res.size();
            if (size > 1) {
                if (integer != res.get(size - 1) + res.get(size - 2)) {
                    continue;
                }
            }
            add=true;
            res.add(integer);
            List<Integer> integers = splitIntoFibonacciRoll(res,num.substring(i + 1));
            if ((num.length()<=i+1||integers.size()>0)&&res.size() > 2) {
                boolean flag = true;
                for (int j = 2; j < res.size(); j++) {
                    if (res.get(j - 1) + res.get(j - 2) != res.get(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return res;
                }
            }
            res.remove(res.size() - 1);
            add=false;
        }
        if (!add) {
            return new ArrayList<>();
        }
        //valid
        for (int i = 2; i < res.size(); i++) {
            if (res.get(i - 1) + res.get(i - 2) != res.get(i)) {
                return new ArrayList<>();
            }
        }
        return res;
    }
}
