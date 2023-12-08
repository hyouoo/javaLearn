package codekata;

import java.util.Arrays;

// 행렬의 곱셈
// https://school.programmers.co.kr/learn/courses/30/lessons/12949
// 입출력 예
//        arr1	                            arr2	                            return
//        {{1, 4}, {3, 2}, {4, 1}}	        {{3, 3}, {3, 3}}	                {{15, 15}, {15, 15}, {15, 15}}
//        {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}	{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}	{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}}
public class Q88 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }

    /*
    00 = 00*00 + 01*10 + 02*20
    01 = 00*01 + 01*11 + 02*21
    02 = 00*02 + 01*12 + 02*22

    10 = 10*00 + 11*10 + 12*20

    */
    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr2[0].length;
        int[][] result = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int i = 0; i < arr2.length; i++) {
                    result[r][c] += arr1[r][i] * arr2[i][c];
                }
            }
        }
        return result;
    }
}
