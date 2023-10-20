package AlgoStudy;

import java.util.stream.IntStream;

//문제 설명
//        정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//제한 사항
//        n은 0 이상 3000이하인 정수입니다.
//입출력 예
//        n	    return
//        12	28
//        5	    6
public class Q4 {
    public static void main(String[] args) {
        int num = 25;
        System.out.println(Solution4.solution(num));
        System.out.println(IntStream.range(1, (int) Math.sqrt(num)+1)
                .filter(i -> num % i == 0));
    }

    private static class Solution4 {
        private static int solution(int n) {
            int result = 0;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0 && i != n / i) {
                    result += i + n / i;
                } else if (n % i == 0 && i == n / i) {
                    result += i;
                }
            }
            return result;
        }
    }
}
