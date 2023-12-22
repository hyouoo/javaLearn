package codekata;

import java.util.Arrays;

// 2개 이하로 다른 비트
// https://school.programmers.co.kr/learn/courses/30/lessons/77885
// 입출력 예
//        numbers	result
//        [2,7]	    [3,11]
public class Q101 {
    public static void main(String[] args) {
        long[] numbers = {2, 17};
        Solution101 solution = new Solution101();
        System.out.println(Arrays.toString(solution.solution(numbers)));
    }
}

class Solution101 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long target = numbers[i]++;
            answer[i] = target + (target ^ numbers[i] >> 2);
        }
        return answer;
    }
}
