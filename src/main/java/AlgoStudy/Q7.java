package AlgoStudy;

import java.util.Arrays;

// 자연수 뒤집어 배열로 만들기
// 문제 설명
//        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
// 제한 조건
//        n은 10,000,000,000이하인 자연수입니다.
// 입출력 예
//        n	    return
//        12345	[5,4,3,2,1]
public class Q7 {
    public static void main(String[] args) {
        long n = 7865789907L;
        System.out.println(Arrays.toString(Solution7.solution(n)));

        int[] ints = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(Solution7.reverseInts(ints)));
    }

    private static class Solution7 {
        private static int[] solution(long n) {
            int[] result = new int[(int) Math.log10(n) + 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = (int) (n % 10);
                n /= 10;
            }
            return result;
        }

        private static int[] reverseInts(int[] ints) {
            int[] result = new int[ints.length];
            for (int i = 0; i < ints.length; i++) {
                result[i] = ints[ints.length - 1 - i];
            }
            return result;
        }
    }
}
