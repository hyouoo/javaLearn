package codekata;

import java.util.Arrays;

// 삼각 달팽이
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// 입출력 예
//        n	result
//        4	[1,2,9,3,10,8,4,5,6,7]
//        5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
//        6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
public class Q108 {
    public static void main(String[] args) {
        int n = 4;
        Solution108 solution = new Solution108();
        System.out.println(Arrays.toString(solution.solution(n)));
    }
}

class Solution108 {
    public int[] solution(int n) {
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];
        int[][] triangle = new int[n][n];

        int r = -1, c = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    r++;
                } else if (i % 3 == 1) {
                    c++;
                } else {
                    r--;
                    c--;
                }
                triangle[r][c] = num++;
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] == 0) break;
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
}