package codekata;

import java.util.HashSet;
import java.util.Set;

// 연속 부분 수열 합의 개수
// https://school.programmers.co.kr/learn/courses/30/lessons/131701
// 입출력 예
//        elements	    result
//        [7,9,1,1,4]	18
public class Q85 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }

    private static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        int partSum = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = j; k < j + i; k++) {
                    partSum += elements[k % len];
                }
                set.add(partSum);
                partSum = 0;
            }
        }
        return set.size() + 1;
    }
}
