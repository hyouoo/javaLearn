package codekata;

// 숫자 카드 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/135807
// 입출력 예
//        arrayA	    arrayB	        result
//        [10, 17]	    [5, 20]	        0
//        [10, 20]	    [5, 17]	        10
//        [14, 35, 119]	[18, 30, 102]	7
public class Q119 {
    public static void main(String[] args) {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};
        Solution119 solution = new Solution119();
        System.out.println(solution.solution(arrayA, arrayB));
    }
}

class Solution119 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answerA = 0, answerB = 0;
        final int LEN = arrayA.length;

        int gcdA = arrayA[0], gcdB = arrayB[0];
        for (int i = 1; i < LEN; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        if (notDividable(arrayA, gcdB)) answerA = gcdB;
        if (notDividable(arrayB, gcdA)) answerB = gcdA;

        return Math.max(answerA, answerB);
    }

    private boolean notDividable(int[] array, int gcd) {
        for (int num : array) {
            if (num % gcd == 0) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}