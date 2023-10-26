package AlgoTest;

// [9, 9, 8, 8, 7, 8, 9], [21, 25, 30, 29, 22, 23, 30] -> 96
// [9, 7, 8, 9, 7, 9, 8], [23, 22, 26, 26, 29, 27, 22] -> 110
// [9, 9, 9, 9, 7, 9, 8], [23, 23, 30, 28, 30, 23, 23] -> 102
public class Q2 {
    public static void main(String[] args) {
        Q2 method = new Q2();
        int[][][] arrs = {
                {{9, 9, 8, 8, 7, 8, 9}, {21, 25, 30, 29, 22, 23, 30}},
                {{9, 7, 8, 9, 7, 9, 8}, {23, 22, 26, 26, 29, 27, 22}},
                {{9, 9, 9, 9, 7, 9, 8}, {23, 23, 30, 28, 30, 23, 23}},
        };
        for (int[][] arr: arrs) {
            System.out.println(method.solution(arr[0], arr[1]));
        }
    }

    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int[] times = new int[arr1.length];

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] >=29) arr2[i] = 21;
        }
        for (int i = 0; i < arr1.length; i++) {
            times[i] = arr2[i] - arr1[i];
        }
        for (int time : times) {
            answer += time;
        }
        return answer;
    }
}
