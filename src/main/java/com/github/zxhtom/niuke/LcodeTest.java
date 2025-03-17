package com.github.zxhtom.niuke;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zxhtom
 * 2025/1/22
 */
public class LcodeTest {
    public int search(List<Integer> list, Integer target,int left , int right) {
        int lvalue = list.get(left);
        int rvalue = list.get(right);
        if (lvalue == target) {
            return left;
        }
        if (rvalue == target) {
            return right;
        }
        if (target > lvalue && target < rvalue) {
            int middle=left+(right-left)/2;
            if (target > list.get(middle)) {
                return search(list, target, middle + 1, right);
            } else if (target < list.get(middle)) {
                return search(list, target, left, middle - 1);
            } else {
                return middle;
            }
        }
       return -1;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{3, 5, 67, 8, 3, 9});
        LcodeTest test = new LcodeTest();
        Collections.sort(list);
        int search = test.search(list, 0,0,list.size()-1);
        System.out.println("search = " + search);
        int search2 = test.search(list, 5,0,list.size()-1);
        System.out.println("search2 = " + search2);
        int search3 = test.search(list, 67,0,list.size()-1);
        System.out.println("search3 = " + search3);
    }
}
