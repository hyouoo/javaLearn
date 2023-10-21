package AlgoStudy;

import java.util.Arrays;
import java.util.stream.IntStream;

// 행렬의 덧셈
// 문제 설명
//        행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
//        2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
// 제한 조건
//        행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
// 입출력 예
//        arr1	arr2	return
//        [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
//        [[1],[2]]	[[3],[4]]	[[4],[6]]
public class Q27 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};
        System.out.println(Arrays.toString(Solution.solution(arr1, arr2)));
        System.out.println(Arrays.toString(Solution.solution2(arr1, arr2)));
    }

    private static class Solution {
        private static int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] result = new int[arr1.length][arr1[0].length];
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[0].length; j++) {
                    result[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return result;
        }

        private static int[][] solution2(int[][] arr1, int[][] arr2) {
            if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
                throw new IllegalArgumentException("Input arrays must have the same dimensions.");
            }
            return IntStream.range(0, arr1.length)
                    .mapToObj(i -> IntStream.range(0, arr1[0].length)
                            .map(j -> arr1[i][j] + arr2[i][j])
                            .toArray())
                    .toArray(int[][]::new);
        }
    }
}
