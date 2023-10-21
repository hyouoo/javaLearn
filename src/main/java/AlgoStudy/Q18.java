package AlgoStudy;

import java.util.ArrayList;
import java.util.stream.IntStream;

// 없는 숫자 더하기
// 문제 설명
//        0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
//        numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
//
// 제한사항
//        1 ≤ numbers의 길이 ≤ 9
//        0 ≤ numbers의 모든 원소 ≤ 9
//        numbers의 모든 원소는 서로 다릅니다.
// 입출력 예
//        numbers	        result
//        [1,2,3,4,6,7,8,0]	14
//        [5,8,4,0,6,7,9]	6
public class Q18 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(Solution.solution(numbers));
        System.out.println(Solution.solution2(numbers));
    }

    private static class Solution {
        private static int solution(int[] numbers) {
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int n : numbers) {
                list.add(n);
            }
            for (int i = 1; i < 10; i++) {
                if (!list.contains(i)) {
                    sum += i;
                }
            }
            return sum;
        }

        private static int solution2(int[] numbers) {
            return IntStream.range(1, 10).sum() - IntStream.of(numbers).sum();
        }
    }
}
