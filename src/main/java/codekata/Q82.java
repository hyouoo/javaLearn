package codekata;

// 멀리 뛰기
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
// 입출력 예
//        n	result
//        4	5
//        3	3
//        5 8
//        6 13
public class Q82 {
    public static void main(String[] args) {
        int n = 2000;
        System.out.println(solution(n));
    }

    private static long solution(int n) {
        long[] record = new long[n + 1];
        int div = 1234567;

        for (int i = 1; i < n + 1; i++) {
            if (i == 1 || i == 2) {
                record[i] = i;
                continue;
            }
            record[i] = record[i - 2] % div + record[i - 1] % div;
        }

        return record[n] % div;
    }
}
