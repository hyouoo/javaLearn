package codekata;

import java.util.Arrays;

// H-index
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
// 입출력 예
//        citations	        return
//        [3, 0, 6, 1, 5]	3
public class Q86 {
    public static void main(String[] args) {
        int[] citations = {1, 3, 4};
        System.out.println(solution(citations));
    }

    private static int solution(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        int idx = 1;
        for (int i = 1; i <= len; i++) {
            if (citations[len - i] >= idx) {
                idx++;
            } else {
                return idx - 1;
            }
        }
        return idx - 1;
    }
}
