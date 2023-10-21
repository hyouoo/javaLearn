package AlgoStudy;

// 수박수박수박수박수박수?
// 문제 설명
//        길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
//        예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
// 제한 조건
//        n은 길이 10,000이하인 자연수입니다.
// 입출력 예
//        n	    return
//        3	    "수박수"
//        4	    "수박수박"
public class Q21 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Solution.solution(n));
        System.out.println(Solution.solution2(n));
    }

    private static class Solution {
        private static String solution(int n) {
            String result = "";
            for (int i = 0; i < n; i++) {
                result += i % 2 == 0 ? "수" : "박";
            }
            return result;
        }

        private static String solution2(int n) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append(i % 2 == 0 ? "수" : "박");
            }
            return result.toString();
        }
    }
}
