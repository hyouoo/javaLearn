package codekata;

import java.util.HashMap;
import java.util.Map;

// 괄호 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/76502
// 입출력 예
//        s	        result
//        "[](){}"	3
//        "}]()[{"	2
//        "[)(]"	0
//        "}}}"	    0
public class Q84 {
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");
        StringBuilder sb = new StringBuilder(s);

        return 0;
    }
}
