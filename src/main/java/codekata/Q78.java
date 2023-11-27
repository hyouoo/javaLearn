package codekata;

// 피보나치 수
// https://school.programmers.co.kr/learn/courses/30/lessons/12945
// 입출력 예
//        n	return
//        3	2
//        5	5
public class Q78 {
    public static void main(String[] args) {
        int n = 100000;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] record = new int[n + 1];
        record[0] = 0;
        record[1] = 1;
        int div = 1234567;
        for (int i = 2; i < n + 1; i++) {
            record[i] = (record[i - 2] % div + record[i - 1] % div) % div;
        }
        return record[n];
    }
}
