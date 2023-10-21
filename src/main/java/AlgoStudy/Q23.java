package AlgoStudy;

import java.util.stream.IntStream;

// 약수의 개수와 덧셈
// 문제 설명
//        두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
// 제한사항
//        1 ≤ left ≤ right ≤ 1,000
// 입출력 예
//        left	right	result
//        13	17	43
//        24	27	52
public class Q23 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(Solution.solution(left, right));
        System.out.println(IntStream.rangeClosed(left, right)
                .map(index -> index % Math.sqrt(index) == 0 ? -index : index)
                .sum());
    }

    private static class Solution {
        private static int solution(int left, int right) {
            int result = 0;
            for (int i = left; i <= right; i++) {
                result = Math.sqrt(i) - (int) Math.sqrt(i) == 0 ? result - i : result + i;
                // i % Math.sqrt(i) == 0
            }
            return result;
        }
    }
}
