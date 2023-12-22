package codekata;

import java.util.Arrays;

// 숫자 변환하기
// https://school.programmers.co.kr/learn/courses/30/lessons/154538
// 입출력 예
//        x	    y	n	result
//        10	40	5	2
//        10	40	30	1
//        2	    5	4	-1
public class Q100 {
    public static void main(String[] args) {
        int x = 10, y = 40, n = 5;
        Solution100 solution = new Solution100();
        System.out.println(solution.solution(x, y, n));
    }
}

class Solution100 {

    public int solution(int x, int y, int n) {
        int[] memo = new int[y + 1];
        Arrays.fill(memo, y + 1);
        memo[x] = 0;
        for (int i = x; i <= y; i++) {
            if (memo[i] == y + 1) continue;
            if (i + n <= y) {
                memo[i + n] = Math.min(memo[i + n], memo[i] + 1);
            }
            if (i * 2 <= y) {
                memo[i * 2] = Math.min(memo[i * 2], memo[i] + 1);
            }
            if (i * 3 <= y) {
                memo[i * 3] = Math.min(memo[i * 3], memo[i] + 1);
            }
        }
        return memo[y] == y + 1 ? -1 : memo[y];
    }
}
