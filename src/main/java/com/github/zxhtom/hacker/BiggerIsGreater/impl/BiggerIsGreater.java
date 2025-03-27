package com.github.zxhtom.hacker.BiggerIsGreater.impl;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/14
 */
public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] chars = w.toCharArray();
        for (int j = chars.length - 1; j >= 0; j--) {
            for (int length = j - 1; length >= 0; length--) {
                if (chars[length] < chars[j]) {
                    char[] tmpchars = new char[chars.length - 1 - length];
                    int slow = 0, fast = 0;
                    while (slow < tmpchars.length) {
                        if (length + fast == j) {
                            fast++;
                            continue;
                        }
                        tmpchars[slow] = chars[length + fast];
                        slow++;
                        fast++;
                    }
                    Arrays.sort(tmpchars);
                    chars[length] = chars[j];
                    for (int i = 0; i < tmpchars.length; i++) {
                        chars[length + 1 + i] = tmpchars[i];
                    }
                    return new String(chars);
                } else if (chars[length] < chars[length + 1]) {
                    break;
                }
            }
        }
        return "no answer";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = BiggerIsGreater.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
