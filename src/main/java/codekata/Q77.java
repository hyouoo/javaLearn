package codekata;

// 이진 변환 반복하기
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 입출력 예
//        s	                result
//        "110010101001"	[3,8]
//        "01110"	        [3,3]
//        "1111111"	        [4,1]

import java.util.Arrays;

public class Q77 {

    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int countZero = 0, count = 0;
        while (!s.equals("1")) {
            count++;
            int sL = s.length();
            s = s.replaceAll("0", "");
            countZero += sL - s.length();
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{count, countZero};
    }
}
