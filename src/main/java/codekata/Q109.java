package codekata;

import java.util.Arrays;

// 연속된 부분 수열의 합
// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// 입출력 예
//        sequence	            k	result
//        [1, 2, 3, 4, 5]	    7	[2, 3]
//        [1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
//        [2, 2, 2, 2, 2]	    6	[0, 2]
public class Q109 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        Solution109 solution = new Solution109();
        System.out.println(Arrays.toString(solution.solution(sequence, k)));
    }
}

class Solution109 {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int[] answer = {0, len};

        int sum = 0;
        for (int pL = 0, pR = 0; pL < len; pL++) {
            while (pR < len && sum < k) {
                sum += sequence[pR++];
            }
            if (sum == k && pR - pL - 1 < answer[1] - answer[0]) {
                answer[0] = pL;
                answer[1] = pR - 1;
            }
            sum -= sequence[pL];
        }
        return answer;
    }
}