package com.github.zxhtom.leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author zxhtom
 * 2023/12/19
 */
public class Leetcode65 {
    public boolean isNumber(String s) {
        NumberMotion motion = new NumberMotion();
        if(s.endsWith("e")) return false;
        if(s.endsWith("E")) return false;
        if(s.endsWith("+")) return false;
        if(s.endsWith("-")) return false;
        if(s.endsWith("-.")) return false;
        if(s.endsWith("+.")) return false;
        if(".".equals(s)) return false;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = motion.get(s.charAt(i));
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    class NumberMotion {
        private int dotCount = 0;
        private int acnCount = 0;
        private int scCount = 0;
        private int template = 0b0101;
        private int acn = 0b0010;
        private int sc = 0b0001;
        private static final String START = "start";
        private static final String DOT = "dot";
        private static final String END = "end";
        private static final String SIGN = "sign";
        private static final String NUMBER = "number";
        private static final String SCINECE = "scinece";

        private String state = "start";
        private List<String> condition = new ArrayList<String>() {{
            add("[+-]");
            add("\\.");
            add("\\d+");
            add("[eE]");
        }};

        private Map<String, List<String>> table = new HashMap<String,List<String>>(){
            {
                put(START, Arrays.asList(new String[]{SIGN,DOT,NUMBER,END}));
                put(DOT, Arrays.asList(new String[]{END,END,NUMBER,SCINECE}));
                put(SIGN, Arrays.asList(new String[]{END,DOT,NUMBER,END}));
                put(NUMBER, Arrays.asList(new String[]{END,DOT,NUMBER,SCINECE}));
                put(SCINECE, Arrays.asList(new String[]{NUMBER,END,NUMBER,END}));
            }
        };

        public boolean get(char c) {
            int col = getCol(c);
            if (col ==-1) {
                return false;
            }
            state = table.get(state).get(col);
            if (END.equals(state)) {
                return false;
            }
            if (state.equals(DOT)&&dotCount > 0) {
                return false;
            }
            if (state.equals(SCINECE) && (acnCount == 0||scCount>0)) {
                return false;
            }
            int temp = 1 << (3 - col);
            if (temp == (temp & template)) {
                dotCount++;
            }
            if (temp == (temp & acn)) {
                acnCount++;
            }
            if (temp == (temp & sc)) {
                scCount++;
            }
            return true;
        }

        private int getCol(char c) {
            for (int i = 0; i < condition.size(); i++) {
                String regex = condition.get(i);
                Pattern p=Pattern.compile(regex);
                Matcher m = p.matcher(c+"");
                if (m.matches()) {
                    return i;
                }
            }
            return -1;
        }

    }
}
