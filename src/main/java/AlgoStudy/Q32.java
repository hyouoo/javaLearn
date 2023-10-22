package AlgoStudy;

import java.util.stream.IntStream;

// 삼총사
// 문제 설명
//        한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다.
//        이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다.
//        예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때,
//        첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다.
//        또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다.
//        따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
//        한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때,
//        학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
// 제한사항
//        3 ≤ number의 길이 ≤ 13
//        -1,000 ≤ number의 각 원소 ≤ 1,000
//        서로 다른 학생의 정수 번호가 같을 수 있습니다.
// 입출력 예
//        number	                result
//        [-2, 3, 0, 2, -5]	        2
//        [-3, -2, -1, 0, 1, 2, 3]	5
//        [-1, 1, -1, 1]	        0
public class Q32 {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(Solution.solution(number));
        System.out.println(Solution.solution2(number));
    }

    private static class Solution {
        private static int solution(int[] number) {
            int len = number.length;
            int count = 0;
            // 인덱스 조합 ex. (012 013 014 023 024 034 123 124 134 234)
            // i(0 ~ n-2), j(i+1 ~ n-1), k(j+1 ~ n) 삼중 for문?
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    for (int k = j + 1; k < len; k++) {
                        if (number[i] + number[j] + number[k] == 0) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        private static long solution2(int[] numbers) {
            return IntStream.range(0, numbers.length - 2)
                    .mapToLong(i ->
                            IntStream.range(i + 1, numbers.length - 1)
                                    .mapToLong(j ->
                                            IntStream.range(j + 1, numbers.length)
                                                    .filter(k -> numbers[i] + numbers[j] + numbers[k] == 0)
                                                    .count()
                                    )
                                    .sum()
                    )
                    .sum();
        }

    }
}
