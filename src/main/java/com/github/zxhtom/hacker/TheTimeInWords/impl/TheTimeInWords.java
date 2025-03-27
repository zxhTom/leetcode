package com.github.zxhtom.hacker.TheTimeInWords.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/26
 */
public class TheTimeInWords {
    static List<String> HOURS = Arrays.asList(new String[]{
            "", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve"
    });
    static List<String> PRE_MINUTES = Arrays.asList(new String[]{
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half"
    });
    static List<String> format = Arrays.asList(new String[]{
            "%s o' clock",
            "%s past %s",
            "%s to %s"
    });

    public static String timeInWords(int h, int m) {
        // Write your code here
        if (m == 0) {
            return String.format(format.get(0), HOURS.get(h));
        }
        int level = (m - 1) / 30;
        int remain = (Math.abs(m - 60 * level) - 1) % 30 + 1;
        String minute = "";
        if (remain == 1) {
            minute = " minute";
        } else if (remain % 15 == 0) {
            minute = "";
        } else {
            minute = " minutes";
        }
        return String.format(format.get(level + 1), PRE_MINUTES.get(remain)+minute, HOURS.get(h + level));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = TheTimeInWords.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
