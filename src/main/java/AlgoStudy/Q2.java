package AlgoStudy;

import java.util.stream.IntStream;

//평균 구하기
// 문제 설명
//        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
// 제한사항
//        arr은 길이 1 이상, 100 이하인 배열입니다.
//        arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
// 입출력 예
//        arr	    return
//        [1,2,3,4]	 2.5
//        [5,5]	      5
public class Q2 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        System.out.println(Solution2.solution(ints));
        System.out.println(IntStream.of(ints).average().orElse(0));
    }

    private static class Solution2 {
        private static double solution(int[] ints) {
            double result = 0;
            for (int n : ints) {
                result += n;
            }
            return result / ints.length;
        }
    }
}
