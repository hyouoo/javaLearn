package AlgoStudy;

// 이상한 문자 만들기
// 문제 설명
//        문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
//        각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
// 제한 사항
//        문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//        첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
// 입출력 예
//        s	                return
//        "try hello world"	"TrY HeLlO WoRlD"
public class Q31 {
    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(Solution.solution(s));
        System.out.println(Solution.solution2(s));
        System.out.println(Solution.solution3(s));
    }

    private static class Solution {
        private static String solution(String s) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            int restartIndex = 0;

            while (index < s.length()) {
                if (s.charAt(index) == ' ') {
                    restartIndex = 1;
                }
                if (restartIndex % 2 == 0) {
                    result.append(Character.toUpperCase(s.charAt(index)));
                } else {
                    result.append(Character.toLowerCase(s.charAt(index)));
                }
                index++;
                restartIndex++;
            }
            return result.toString();
        }

        private static String solution2(String s) {
            StringBuilder result = new StringBuilder();
            boolean toUpperCase = true;
            for (char c : s.toCharArray()) {
                if (Character.isWhitespace(c)) {
                    toUpperCase = true;
                    result.append(c);
                } else {
                    if (toUpperCase) {
                        result.append(Character.toUpperCase(c));
                    } else {
                        result.append(Character.toLowerCase(c));
                    }
                    toUpperCase = !toUpperCase;
                }
            }
            return result.toString();
        }

        private static String solution3(String s) {
            StringBuilder answer = new StringBuilder();
            int cnt = 0;
            String[] array = s.split("");

            for (String ss : array) {
                cnt = ss.contains(" ") ? 0 : cnt + 1;
                answer.append(cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase());
            }
            return answer.toString();
        }
    }
}
