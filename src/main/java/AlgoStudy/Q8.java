package AlgoStudy;

import java.util.Arrays;

// 문자열을 정수로 바꾸기
// 문제 설명
//        문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
// 제한 조건
//        s의 길이는 1 이상 5이하입니다.
//        s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//        s는 부호와 숫자로만 이루어져있습니다.
//        s는 "0"으로 시작하지 않습니다.
// 입출력 예
//        예를들어 str이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
//        str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
public class Q8 {
    public static void main(String[] args) {
        String string = "1234";
        System.out.println(Solution8.solution(string));
        System.out.println(Integer.parseInt(string));
    }

    private static class Solution8 {
        private static int solution(String string) {
            int result = 0;
            boolean negative = false;
            if (string.charAt(0) == '-') {
                negative = true;
            }
            for (int i = 0; i < string.length(); i++) {
                result = result * 10 + (string.charAt(i) - 48);
            }

            //string을 char로 iteration하면서 int로 변환

            return negative ? -result : result;
        }
    }
}
