package codekata;

// k진수에서 소수 개수 구하기
// https://school.programmers.co.kr/learn/courses/30/lessons/92335
// 입출력 예
//        n	        k	result
//        437674	3	3
//        110011	10	2
public class Q95 {
    public static void main(String[] args) {
        int n = 1000000;
        int k = 10;
        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        String kNum = Long.toString(n, k);
        String[] numArr = kNum.split("0");

        int count = 0;
        for (String num : numArr) {
            if (num.isEmpty()) continue;
            if (isPrime(Long.parseLong(num))) count++;
        }
        return count;
    }

    private static boolean isPrime(long n) {
        if (n==1) return false;
        if (n==2) return true;
        for (long i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
