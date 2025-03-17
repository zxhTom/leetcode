package com.github.zxhtom.niuke;

import java.util.Scanner;

/**
 * TODO
 *
 * @author zxhtom
 * 2024/8/9
 */
public class Test004File {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        StringBuilder stringBuilder = new StringBuilder();
        while (in.hasNext()) {
            stringBuilder.append(in.nextLine());
        }
        int i = countStatements(stringBuilder.toString());
        System.out.println(i);
    }
    public static int countStatements(String content){
        int count=0;
        boolean isComment=false;
        boolean isString=false;
        boolean escape=false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char target = content.charAt(i);
            if (isComment) {
                if (target == '\n') {
                    isComment=false;
                }
                continue;
            }
            if (isString) {
                if (target == '\\' && !escape) {
                    escape = true;
                } else if (target == '"' | target == '\'' && !escape) {
                    isString = false;
                } else {
                    escape = false;
                }
            } else {
                if (target == '-' && i+1 < content.length() && content.charAt(i + 1)=='-'&&i+2 < content.length() && Character.isWhitespace(content.charAt(i+2))) {
                    isComment = true;
                    i++;
                } else if (target == '"' || target == '\'') {
                    isString = true;
                    res.append(target);
                } else if (target == ';') {
                    if (res.length() > 0) {
                        count+=1;
                        res.setLength(0);
                    }
                } else if (!Character.isWhitespace(target)) {
                    res.append(target);
                }
            }
        }
        if (res.length() > 0) {
            count++;
        }
        return count;
    }
}
