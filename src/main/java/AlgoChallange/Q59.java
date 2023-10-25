package AlgoChallange;

import java.util.HashMap;
import java.util.Map;

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
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    // RTCFJMAN 각각의 키값으로 map 생성 초기 밸류는 0, 아니면 이중배열로? {{R, T}, {C, F}, {J, M}, {A, N}}
    // choices 1 의 점수에 따라 survey 1의 항목을 조회하고 맞는 항목에 점수 할당
    // 각 타입별 점수를 더해 출력, 점수가 같으면 앞에꺼?(미리 알파벳 순으로 생성)
    private static String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('R', 0);
            put('T', 0);
            put('C', 0);
            put('F', 0);
            put('J', 0);
            put('M', 0);
            put('A', 0);
            put('N', 0);
        }};

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
            }
        }
        char[] result = new char[4];
        result[0] = map.get('R') >= map.get('T') ? 'R' : 'T';
        result[1] = map.get('C') >= map.get('F') ? 'C' : 'F';
        result[2] = map.get('J') >= map.get('M') ? 'J' : 'M';
        result[3] = map.get('A') >= map.get('N') ? 'A' : 'N';

        return String.valueOf(result);
    }
}
