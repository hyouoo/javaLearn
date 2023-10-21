package AlgoStudy;

// 가운데 글자 가져오기
// 문제 설명
//        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
// 제한사항
//        s는 길이가 1 이상, 100이하인 스트링입니다.
// 입출력 예
//        s	        return
//        "abcde"	"c"
//        "qwer"	"we"
public class Q20 {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(Solution.solution(s));
        System.out.println(Solution.solution2(s));
    }

    private static class Solution {
        private static String solution(String s) {
            char[] charS = s.toCharArray();
            int len = charS.length;
            boolean even = len % 2 == 0;
            return String.valueOf(charS, even ? len / 2 - 1 : len / 2, even ? 2 : 1);
        }

        private static String solution2(String s) {
            int mid = s.length() / 2;
            boolean odd = s.length() % 2 == 1;
            return s.substring(odd ? mid : mid - 1, mid + 1);
        }
    }
}
