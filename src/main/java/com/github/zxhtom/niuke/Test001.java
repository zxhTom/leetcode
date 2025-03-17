package com.github.zxhtom.niuke;

import org.apache.logging.log4j.util.Strings;

import java.util.Stack;

/**
 * TODO
 *
 * @author zxhtom
 * 2024/8/2
 */
public class Test001 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        s=new StringBuffer(s).reverse().toString();
        t=new StringBuffer(t).reverse().toString();
        // write code here
        int min=s.length()<t.length()?s.length():t.length();
        String max=s.length()>t.length()?s:t;
        int pre=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<min;i++){
            int tmp=pre+(s.charAt(i)-'0')+(t.charAt(i)-'0');
            stack.add(tmp % 10);
            pre=tmp/10;
        }
        if (s.length() == t.length()) {
            if (pre != 0) {
                stack.add(pre);
            }
        } else {

            for(int i=min;i<max.length();i++){
                int tmp=pre+Integer.valueOf(String.valueOf(max.charAt(i)));
                stack.add(tmp % 10);
                pre=tmp/10;
//                if (pre == 0) {
//                    res=new StringBuffer(max.substring(i)).reverse().toString()+res;
//                    break;
//                }
            }
            if (pre != 0) {
                stack.add(pre);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty())
            stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Test001 demo = new Test001();
        String solve = demo.solve("733064366", "459309139");
        System.out.println("solve = " + solve);
    }
}
