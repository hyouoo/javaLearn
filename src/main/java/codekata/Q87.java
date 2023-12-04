package codekata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// n^2 배열 자르기
// https://school.programmers.co.kr/learn/courses/30/lessons/87390
// 입출력 예
//        n	left	right	result
//        3	2	    5	    [3,2,2,3]
//        4	7	    14	    [4,3,3,3,4,4,4,4]
public class Q87 {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        System.out.println(Arrays.toString(solution(n, left, right)));
    }

    private static int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left + 1)];
        for (long i = left, j = 0; i < right + 1; i++, j++) {
            int x = (int) (i % n);
            int y = (int) (i / n);
            result[(int) j] = Math.max(x, y) + 1;
        }
        return result;
    }

    private static int[] solution2(int n, long left, long right) {
        List<Integer> fullArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    fullArray.add(j + 1);
                } else {
                    fullArray.add(i + 1);
                }
            }
        }
        int[] result = new int[(int) (right - left + 1)];
        for (long i = left, j = 0; i < right+1 ; i++, j++) {
            result[(int) j] = fullArray.get((int) i);
        }

        return result;
    }
}
