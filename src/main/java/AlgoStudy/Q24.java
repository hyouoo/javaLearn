package AlgoStudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 문자열 내림차순으로 배치하기
// 문제 설명
//        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
// 제한 사항
//        str은 길이 1 이상인 문자열입니다.
// 입출력 예
//        s	return
//        "Zbcdefg"	"gfedcbZ"
public class Q24 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(Solution.solution(s));
        System.out.println(Solution.solution2(s));
        System.out.println(Stream.of(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

    private static class Solution {
        private static String solution(String s) {
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            for (int i = 0; i < charS.length / 2; i++) {
                char temp = charS[i];
                charS[i] = charS[charS.length - 1 - i];
                charS[charS.length - 1 - i] = temp;
            }
            return String.valueOf(charS);
        }

        private static String solution2(String s) {
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            return new StringBuilder(String.valueOf(charS)).reverse().toString();
        }
    }
}
