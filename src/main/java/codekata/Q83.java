package codekata;

// 귤 고르기
// https://school.programmers.co.kr/learn/courses/30/lessons/138476
// 입출력 예
//        k	tangerine	result
//        6	[1, 3, 2, 5, 4, 5, 2, 3]	3
//        4	[1, 3, 2, 5, 4, 5, 2, 3]	2
//        2	[1, 1, 1, 1, 2, 2, 2, 3]	1

import java.util.*;

public class Q83 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k, tangerine));

    }
    private static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tangerine) {
            map.put(n, map.get(n) == null ? 1 : map.get(n) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());

        int count = 0, numOfSize = 1;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            count += entry.getValue();
            if (count < k) {
                numOfSize++;
            } else {
                return numOfSize;
            }
        }
        return 0;
    }
}
