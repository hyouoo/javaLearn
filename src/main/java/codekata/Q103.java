package codekata;

// 가장 큰 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42746
// 입출력 예
//        numbers	        return
//        [6, 10, 2]	    "6210"
//        [3, 30, 34, 5, 9]	"9534330"

import java.util.Arrays;

public class Q103 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        Solution103 solution = new Solution103();
        System.out.println(solution.solution(numbers));
        System.out.println("3".compareTo("30"));
    }
}

class Solution103 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] st = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            st[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(st, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (st[0].equals("0")) return "0";

        for (String s : st) {
            sb.append(s);
        }

        return sb.toString();
    }
}
