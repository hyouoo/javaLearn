package codekata;

// 점 찍기
// https://school.programmers.co.kr/learn/courses/30/lessons/140107
// 입출력 예
//        k	d	result
//        2	4	6
//        1	5	26
public class Q116 {
    public static void main(String[] args) {
        int k = 2, d = 4;
        Solution116 solution = new Solution116();
        System.out.println(solution.solution(k, d));
    }
}

class Solution116 {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            long temp = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2)) / k + 1;
            answer += temp;
        }
        return answer;
    }
}