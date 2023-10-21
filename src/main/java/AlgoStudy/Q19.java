package AlgoStudy;

import java.util.ArrayList;
import java.util.Arrays;

// 제일 작은 수 제거하기
// 문제 설명
//        정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
//        단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
//        예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
// 제한 조건
//        arr은 길이 1 이상인 배열입니다.
//        인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
// 입출력 예
//        arr	    return
//        [4,3,2,1]	[4,3,2]
//        [10]	    [-1]
public class Q19 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3};
        System.out.println(Arrays.toString(Solution.solution(arr)));
        System.out.println(Arrays.toString(Solution.solution2(arr)));
    }

    private static class Solution {
        private static int[] solution(int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            int minNum = arr[0];
            for (int n : arr) {
                minNum = Math.min(minNum, n);
            }
//            int minNum = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
            for (int j : arr) {
                if (j != minNum) {
                    list.add(j);
                }
            }
            if (list.isEmpty()) {
                list.add(-1);
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
//            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private static int[] solution2(int[] arr) {
            if (arr.length == 1) return new int[]{-1};
            int minNum = Arrays.stream(arr).min().orElse(0);
            return Arrays.stream(arr).filter(i -> i != minNum).toArray();
        }
    }
}
