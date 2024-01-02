package codekata;

import java.util.Arrays;

// 행렬 테두리 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// 입출력 예시
//        rows	columns	queries	                                    result
//        6	    6	    [[2,2,5,4],[3,3,6,6],[5,1,6,3]]	            [8, 10, 25]
//        3	    3	    [[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
//        100	97	    [[1,1,100,97]]	                            [1]
public class Q112 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        Solution112 solution = new Solution112();
        System.out.println(Arrays.toString(solution.solution(rows, columns, queries)));
    }
}

class Solution112 {
    int[][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }

    private int rotate(int[] query) {
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;

        int temp = matrix[r1][c1];
        int min = temp;
        for (int i = r1; i < r2; i++) {
            matrix[i][c1] = matrix[i + 1][c1];
            min = Math.min(min, matrix[i][c1]);
        }
        for (int i = c1; i < c2; i++) {
            matrix[r2][i] = matrix[r2][i + 1];
            min = Math.min(min, matrix[r2][i]);
        }
        for (int i = r2; i > r1; i--) {
            matrix[i][c2] = matrix[i - 1][c2];
            min = Math.min(min, matrix[i][c2]);
        }
        for (int i = c2; i > c1; i--) {
            matrix[r1][i] = matrix[r1][i - 1];
            min = Math.min(min, matrix[r1][i]);
        }
        matrix[r1][c1 + 1] = temp;
        return min;
    }
}