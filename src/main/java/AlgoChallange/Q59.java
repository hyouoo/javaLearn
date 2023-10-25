package AlgoChallange;

// 성격 유형 검사하기
// https://school.programmers.co.kr/learn/courses/30/lessons/118666
//      choices	뜻
//        1	    매우 비동의
//        2	    비동의
//        3	    약간 비동의
//        4	    모르겠음
//        5	    약간 동의
//        6	    동의
//        7	    매우 동의
// 입출력 예
//        survey	                        choices	        result
//        ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
//        ["TR", "RT", "TR"]	            [7, 1, 3]	    "RCJA"
public class Q59 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(solution(n));
    }

    // RTCFJMAN 각각의 키값으로 map 생성 초기 밸류는 0, 아니면 이중배열로? {{R, T}, {C, F},
    // choices 1 의 점수에 따라 survey 1의 항목을 조회하고 맞는 항목에 점수 할당
    // 각 타입별 점수를 더해 출력, 점수가 같으면 앞에꺼?(미리 알파벳 순으로 생성)
    private static int solution(int n) {

        return n;
    }
}
