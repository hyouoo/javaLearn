package codekatalv6;

// 두 원 사이의 정수 쌍
// https://school.programmers.co.kr/learn/courses/30/lessons/181187
// 입출력 예
//      r1	r2	result
//      2	3	20
public class Q130 {
    public static void main(String[] args) {
        int r1 = 2, r2 = 3;
        Solution130 solution = new Solution130();
        System.out.println(solution.solution(r1, r2));
    }
}

class Solution130 {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            int start = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            int end = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
            answer += end - start + 1;
        }
        return 4 * answer;
    }
}