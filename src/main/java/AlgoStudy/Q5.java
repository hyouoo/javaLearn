package AlgoStudy;

import java.util.stream.IntStream;

//문제 설명
//        자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
//        답이 항상 존재함은 증명될 수 있습니다.
//제한사항
//        3 ≤ n ≤ 1,000,000
//입출력 예
//        n	    result
//        10	3
//        12	11
public class Q5 {
    public static void main(String[] args) {
        int num = 12;
        System.out.println(Solution5.solution(num));
        System.out.println(IntStream.range(2, num).filter(i -> num % i == 1)
                .findFirst().orElse(0));
    }

    private static class Solution5 {
        private static int solution(int n) {
            for (int i = 2; i < n; i++) {
                if (n % i == 1) {
                    return i;
                }
            }
            return 0;
        }
    }
}
