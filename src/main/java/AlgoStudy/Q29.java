package AlgoStudy;

import java.util.Arrays;

// 최대공약수와 최소공배수
// 문제 설명
//        두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
//        배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
//        예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
// 제한 사항
//        두 수는 1이상 1000000이하의 자연수입니다.
// 입출력 예
//        n	m	return
//        3	12	[3, 12]
//        2	5	[1, 10]
public class Q29 {
    public static void main(String[] args) {
        int n = 12;
        int m = 11;
        System.out.println(Arrays.toString(Solution.solution(n, m)));
        System.out.println(Arrays.toString(Solution.gcdlcm(n, m)));
    }

    private static class Solution {
        private static int[] solution(int n, int m) {
            int[] result = {1, 1};
            for (int i = 1; i <= Math.min(n, m); i++) {
                if (n % i == 0 && m % i == 0) {
                    result[0] = i;
                }
            }
            result[1] = n * m / result[0];
            return result;
        }

        private static int[] gcdlcm(int a, int b) {
            int[] answer = new int[2];

            answer[0] = gcd(a, b);
            answer[1] = (a * b) / answer[0];
            return answer;
        }

        private static int gcd(int p, int q) {
            if (q == 0) return p;
            return gcd(q, p % q);
        }


    }
}
