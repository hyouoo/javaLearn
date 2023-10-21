package AlgoStudy;

import java.util.Arrays;
import java.util.stream.IntStream;

// 하샤드 수
// 문제 설명
//        양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
//
// 제한 조건
//        x는 1 이상, 10000 이하인 정수입니다.
// 입출력 예
//        x	return
//        10	true
//        12	true
//        11	false
//        13	false
public class Q11 {
    public static void main(String[] args) {
        int x = 13;
        System.out.println(Solution.solution(x));
        System.out.println(Solution.solution2(x));
    }

    private static class Solution {
        private static boolean solution(int x) {
            int originX = x;
            String str = String.valueOf(x);
            int[] ints = new int[str.length()];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = x % 10;
                x /= 10;
            }
            int sum = Arrays.stream(ints).sum();
            return originX % sum == 0;
        }

        private static boolean solution2(int x) {
            return x % Integer.toString(x).chars().map(i -> i - '0').sum() == 0;
        }
    }
}
