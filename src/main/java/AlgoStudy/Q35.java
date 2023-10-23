package AlgoStudy;

// 시저 암호
// 문제 설명
//        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
//        예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
//        문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
// 제한 조건
//        공백은 아무리 밀어도 공백입니다.
//        s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//        s의 길이는 8000이하입니다.
//        n은 1 이상, 25이하인 자연수입니다.
// 입출력 예
//        s	        n	    result
//        "AB"	    1	    "BC"
//        "z"	    1	    "a"
//        "a B z"	4	    "e F d"
public class Q35 {
    public static void main(String[] args) {
        String s = "a B Z";
        int n = 4;
        System.out.println(Solution.solution(s, n));
        System.out.println(Solution.solution2(s, n));
        System.out.println(Solution.solution3(s, n));
    }

    private static class Solution {
        private static String solution(String s, int n) {
            StringBuilder result = new StringBuilder();
            String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
            String capital = alphabet.toUpperCase();
            // s의 요소를 alphabet에서 찾아보고 n만큼 더해서 반환, but z 다음에는 다시 a가 와야 됨
            for (char chr : s.toCharArray()) {
                if (chr == ' ') {
                    result.append(' ');
                } else if (alphabet.contains(String.valueOf(chr))) {
                    result.append(alphabet.charAt(alphabet.indexOf(chr) + n));
                } else if (capital.contains(String.valueOf(chr))) {
                    result.append(capital.charAt(capital.indexOf(chr) + n));
                }
            }
            return result.toString();
        }

        private static String solution2(String s, int n) {
            StringBuilder result = new StringBuilder();
            for (char chr : s.toCharArray()) {
                if (chr == ' ') {
                    result.append(' ');
                } else {
                    char base = Character.isUpperCase(chr) ? 'A' : 'a';
                    char shiftedChar = (char) ((chr + n - base) % 26 + base);
                    result.append(shiftedChar);
                }
            }
            return result.toString();
        }

        private static String solution3(String s, int n) {
            return s.chars().mapToObj(chr -> {
                        if (chr == ' ') {
                            return ' ';
                        } else {
                            char base = Character.isUpperCase(chr) ? 'A' : 'a';
                            return (char) ((chr + n - base) % 26 + base);
                        }
                    })
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
    }
}
