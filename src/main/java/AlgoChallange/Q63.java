package AlgoChallange;

import java.util.Arrays;

// 공원 산책
// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// 입출력 예
//        park	                    routes	            result
//        ["SOO","OOO","OOO"]	    ["E 2","S 2","W 1"]	[2,1]
//        ["SOO","OXX","OOO"]	    ["E 2","S 2","W 1"]	[0,1]
//        ["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
public class Q63 {
    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    private static int[] solution(String[] park, String[] routes) {

        return new int[]{1, 2};
    }
}
