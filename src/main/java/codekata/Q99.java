package codekata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 롤케이크 자르기
// https://school.programmers.co.kr/learn/courses/30/lessons/132265
// 입출력 예
//        topping	                result
//        [1, 2, 1, 3, 1, 4, 1, 2]	2
//        [1, 2, 3, 1, 4]	        0
public class Q99 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        Solution99 solution = new Solution99();
        System.out.println(solution.solution(topping));
    }
}

class Solution99 {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for (int t : topping) {
            map.put(t, map.get(t) - 1);
            set.add(t);
            if (map.get(t) == 0) map.remove(t);
            if (map.size() == set.size()) count++;
        }
        return count;
    }
}
