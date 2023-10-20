package AlgoStudy;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

// 정수 내림차순으로 배치하기
// 문제 설명
//        함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
//        예를들어 n이 118372면 873211을 리턴하면 됩니다.
// 제한 조건
//        n은 1이상 8000000000 이하인 자연수입니다.
// 입출력 예
//        n	        return
//        118372	873211
public class Q10 {
    public static void main(String[] args) {
        long n = 118372L;
        System.out.println(Solution.solution(n));
        System.out.println(Solution.solution2(n));
        System.out.println(Solution.solution3(n));
        String reversedStr = Long.toString(n).chars().mapToObj(c -> (char) c)
                .sorted((a, b) -> Character.compare(b, a))
                .map(Objects::toString).collect(Collectors.joining());
        System.out.println(reversedStr);
    }

    private static class Solution {
        private static long solution(long n) {
            int[] intArray = new int[(int) Math.log10(n) + 1];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = (int) n % 10;
                n /= 10;
            }
            Arrays.sort(intArray);
            long result = 0;
            for (int i = 0; i < intArray.length; i++) {
                result += (long) (intArray[i] * Math.pow(10, i));
            }
            return result;
        }

        private static long solution2(long n) {
            char[] digits = String.valueOf(n).toCharArray(); // Long.toString(n)도 됨
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits)).reverse();
            return Long.parseLong(sb.toString());
        }

        static String res = "";

        private static long solution3(long n) {
            Long.toString(n).chars().sorted().forEach(c -> res = (char) c + res);
            return Long.parseLong(res);
        }
    }
}
