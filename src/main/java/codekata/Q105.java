package codekata;

// 쿼드압축 후 개수 세기
// https://school.programmers.co.kr/learn/courses/30/lessons/68936
// 입출력 예
//        arr	                                                                                                                                            result
//        [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	                                                                                                        [4,9]
//        [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]

import java.util.Arrays;

public class Q105 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        Solution105 solution = new Solution105();
        System.out.println(Arrays.toString(solution.solution(arr)));

    }
}

class Solution105 {
    public int[] solution(int[][] arr) {
        int size = arr.length;
        int pX = 0, pY = 0;
        int[] answer = new int[2];
        quadComp(arr, pX, pY, size, answer);
        return answer;
    }

    private void quadComp(int[][] arr, int pX, int pY, int size, int[] answer) {
        if (checkComp(arr, pX, pY, size)) {
            answer[arr[pX][pY]]++;
            return;
        }
        int newSize = size / 2;
        quadComp(arr, pX, pY, newSize, answer);
        quadComp(arr, pX + newSize, pY, newSize, answer);
        quadComp(arr, pX, pY + newSize, newSize, answer);
        quadComp(arr, pX + newSize, pY + newSize, newSize, answer);
    }

    private boolean checkComp(int[][] arr, int pX, int pY, int size) {
        int target = arr[pX][pY];
        for (int i = pX; i < pX + size; i++) {
            for (int j = pY; j < pY + size; j++) {
                if (arr[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}
