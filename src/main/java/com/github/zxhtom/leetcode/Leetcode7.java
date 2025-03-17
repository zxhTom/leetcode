package com.github.zxhtom.leetcode;

/**
 * TODO
 *https://leetcode.cn/problems/reverse-integer/
 *
 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 假设环境不允许存储 64 位整数（有符号或无符号）。
 示例 1：
 输入：x = 123
 输出：321
 示例 2：
 输入：x = -123
 输出：-321
 示例 3：
 输入：x = 120
 输出：21
 示例 4：
 输入：x = 0
 输出：0
 * @author zxhtom
 * 2023/12/18
 */
public class Leetcode7 {
    public int reverse(int x) {
        Integer result = x%10 ;
        while ((x = x / 10) != 0) {
            int index = x % 10;
            //判断是否 大于 最大32位整数
            if (result>214748364 || (result==214748364 && index>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (result<-214748364 || (result==-214748364 && index<-8)) {
                return 0;
            }
            result = result * 10 + index;
        }
        return result;
    }

}
