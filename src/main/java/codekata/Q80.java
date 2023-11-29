package codekata;

// 예상 대진표
// https://school.programmers.co.kr/learn/courses/30/lessons/12985
// 입출력 예
//        N	A	B	answer
//        8	4	7	3
public class Q80 {
    public static void main(String[] args) {
        int n = 16, a = 7, b = 8;
        System.out.println(solution(n, a, b));
    }

    private static int solution(int n, int a, int b) {
        int count = 0;
        while (a != b) {
            a = toCeil(a);
            b = toCeil(b);
            count++;
        }
        return count;
    }

    private static int toCeil(int a) {
        return (int) Math.ceil((double) a / 2);
    }
}
