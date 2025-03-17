package com.github.zxhtom.hacker.ClimbingTheLeadBoard.impl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/9
 */
public class ClimbingTheLeadBoard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ranked=ranked.stream().distinct().collect(Collectors.toList());
        // Write your code here
        int[] res = new int[player.size()];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < player.size(); i++) {
            map.putIfAbsent(player.get(i), new ArrayList<>());
            List<Integer> list = map.get(player.get(i));
            list.add(i);
        }
        List<Integer> orderedPlayer = player.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int preMatch = 0;
        int rank = 1;
        for (Integer play : orderedPlayer) {
            boolean match = false;
            for (int j = preMatch; j < ranked.size(); j++) {
                preMatch = j;
                List<Integer> integers = map.get(play);
                if (play >= ranked.get(j)) {
                    for (Integer integer : integers) {
                        res[integer] = j+1;
                    }
                    match = true;
                    break;
                }
            }
            if (match) {
                continue;
            }
            List<Integer> integers = map.get(play);
            for (Integer integer : integers) {
                res[integer] = ranked.size()+1;
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
