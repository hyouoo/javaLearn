package AlgoStudy;

// 크기가 작은 부분문자열
// 문제 설명
//        숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서,
//        이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
//        예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다.
//        이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.
// 제한사항
//        1 ≤ p의 길이 ≤ 18
//        p의 길이 ≤ t의 길이 ≤ 10,000
//        t와 p는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.
// 입출력 예
//        t	                p	    result
//        "3141592"	        "271"	2
//        "500220839878"	"7"	    8
//        "10203"	        "15"	3
public class Q33 {
    public static void main(String[] args) {
        String t = "500220839878";
        String p = "7";
        System.out.println(Solution.solution(t, p));
        System.out.println(Solution.solution2(t, p));
    }

    private static class Solution {
        private static int solution(String t, String p) {
            int count = 0;
            int pLen = p.length();

            for (int i = 0; i <= t.length() - pLen; i++) {
                int j = 0;
                if (t.charAt(i) < p.charAt(j)) {
                    count++;
                } else if (t.charAt(i) == p.charAt(j)) {
                    if (pLen == 1) {
                        count++;
                    } else {
                        while (true) {
                            j++;
                            if (t.charAt(i + j) < p.charAt(j)) {
                                count++;
                                break;
                            } else if (t.charAt(i + j) == p.charAt(j)) {
                                if (j == pLen - 1) {
                                    count++;
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return count;
        }

        private static int solution2(String t, String p) {
            int count = 0;
            int tLen = t.length();
            int pLen = p.length();

            for (int i = 0; i <= tLen - pLen; i++) {
                String subStr = t.substring(i, i + pLen);
                if (subStr.compareTo(p) <= 0) {
                    count++;
                }
            }
            return count;
        }
    }
}
