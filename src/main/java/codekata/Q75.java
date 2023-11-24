package codekata;

import java.util.Arrays;

// 최댓값과 최솟값
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// 입출력 예
//        s	            return
//        "1 2 3 4"	    "1 4"
//        "-1 -2 -3 -4"	"-4 -1"
//        "-1 -1"	    "-1 -1"
public class Q75 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int[] ints = Arrays.stream(s.split(" ")).distinct()
                .mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : ints) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return min + " " + max;
    }
}
