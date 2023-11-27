package codekata;

import java.util.Arrays;

// 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
// 입출력 예
//        brown	yellow	return
//        10	2	    [4, 3]
//        8	    1	    [3, 3]
//        24	24	    [8, 6]
public class Q79 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int valid = (brown - 4) / 2;
        for (int i = yellow / 2 == 0 ? 1 : yellow / 2; i > 0; i--) {
            int j = yellow / i;
            if (i + j == valid) {
                return new int[]{j + 2, i + 2};
            }
        }
        return null;
    }
}
