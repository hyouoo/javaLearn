package codekata;

import java.util.Arrays;

// N개의 최소공배수
// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// 입출력 예
//        arr	        result
//        [2,6,8,14]	168
//        [1,2,3]	    6
public class Q81 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);

        int gcd = getGcd(arr[0], arr[1]);
        int lcm = arr[0] * arr[1] / gcd;
        for (int i = 2; i < arr.length; i++) {
            lcm = getLcm(arr[i], lcm);
        }

        return lcm;
    }

    private static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getGcd(b, a % b);
        }
    }

    private static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
}
