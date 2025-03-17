package com.github.zxhtom.hacker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @author zxhtom
 * 2024/9/6
 */
public class HackerRank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=100;i<1000;i++){
            for(int j=100;j<1000;j++){
                Integer tmp = i*j;
                if(list.contains(tmp)){
                    continue;
                }
                Integer rtmp = Integer.valueOf(new StringBuffer(tmp.toString()).reverse().toString());
                if(tmp-rtmp==0){
                    list.add(tmp);
                }
            }
        }
        Collections.sort(list);
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            for(int i=list.size()-1;i>=0;i--){
                if(list.get(i)-n<0){
                    System.out.println(list.get(i));
                    break;
                }
            }
        }
    }
}
