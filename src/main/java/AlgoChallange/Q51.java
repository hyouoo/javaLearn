package AlgoChallange;

import java.util.Arrays;

// 로또의 최고 순위와 최저 순위
// https://school.programmers.co.kr/learn/courses/30/lessons/77484
// 입출력 예
//        lottos	            win_nums	                result
//        [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	    [3, 5]
//        [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
//        [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	    [1, 1]
public class Q51 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25}, win_nums = {31, 10, 45, 1, 6, 19};
//        System.out.println(Arrays.toString(solution(lottos, win_nums)));
        System.out.println(-8>>1);
        System.out.println(-8>>>1);
        byte a = -8;
        byte b = (byte) (a>>>1);
        System.out.println(b);
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int countZero = 0;
        for (int num : lottos) {
            if (num == 0) {
                countZero++;
                continue;
            }
            for (int win : win_nums) {
                if (num == win) {
                    count++;
                    break;
                }
            }
        }
        // count = 0, countZero = 1인 케이스 고려해야 됨 6,6이 나와야 됨
        // count, countZero = 0인 경우에도 6,6이 나와야 됨
//        if (count == 0 && (countZero == 0 || countZero == 1)) return new int[]{6, 6};
        int maxRank = Math.min(7 - (count + countZero), 6);
        int minRank = Math.min(7 - count, 6);
        return new int[]{maxRank, minRank};
    }

    private static int[] solution2(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int answer = 0;
        int hidden = 0;

        Arrays.sort(win_nums);
        for (int lotto : lottos)
            if (Arrays.binarySearch(win_nums, lotto) > -1)
                answer++;
            else if (lotto == 0)
                hidden++;

        return new int[] {rank[answer + hidden], rank[answer]};
    }
}
