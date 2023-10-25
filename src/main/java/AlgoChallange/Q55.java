package AlgoChallange;

// 문자열 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/140108
// 입출력 예
//        s	                result
//        "banana"	        3
//        "abracadabra"	    6
//        "aaabbaccccabba"	3
public class Q55 {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        System.out.println(solution(s));
    }

    // String의 각 char를 for문 루프 돌면서 첫 번째 글자를 tmp에 저장하고 카운트
    // tmp와 다른 글자를 카운트, 카운트가 같으면 결과 카운트 +1 -> tmp에 다음 char할당
    // index가 마지막 값일 때 결과 카운트 +1하고 break
    private static int solution(String s) {
        int baseCount = 0;
        int otherCount = 0;
        int resultCount = 0;
        char tmp = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == tmp) baseCount++;
            else otherCount++;
            if (i == s.length() - 1) {
                resultCount++;
                break;
            }else if (baseCount == otherCount) {
                resultCount++;
                tmp = s.charAt(i + 1);
            }
        }
        return resultCount;
    }
}
