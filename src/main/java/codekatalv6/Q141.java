package codekatalv6;

import java.util.Arrays;

// 당구 연습
// https://school.programmers.co.kr/learn/courses/30/lessons/169198
// 입출력 예
//      m	n	startX	startY	balls	                    result
//      10	10	3	    7	    [[7, 7], [2, 7], [7, 3]]	[52, 37, 116]
public class Q141 {
    public static void main(String[] args) {
        int m = 10, n = 10, startX = 3, startY = 7;
        int[][] balls = {{7, 7}, {2, 7}, {7, 3}};
        Solution141 solution = new Solution141();
        System.out.println(Arrays.toString(solution.solution(m, n, startX, startY, balls)));
    }
}

class Solution141 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i < balls.length; i++) {
            int distX = startX - balls[i][0];
            int distY = startY - balls[i][1];
            if (!(distX == 0 && startY > balls[i][1]))
                answer[i] = (int) Math.min(answer[i], Math.pow(distX, 2) + Math.pow(startY + balls[i][1], 2));
            if (!(distX == 0 && startY < balls[i][1]))
                answer[i] = (int) Math.min(answer[i], Math.pow(distX, 2) + Math.pow(n - startY + n - balls[i][1], 2));
            if (!(startX > balls[i][0] && distY == 0))
                answer[i] = (int) Math.min(answer[i], Math.pow(startX + balls[i][0], 2) + Math.pow(distY, 2));
            if (!(startX < balls[i][0] && distY == 0))
                answer[i] = (int) Math.min(answer[i], Math.pow(m - startX + m - balls[i][0], 2) + Math.pow(distY, 2));
        }
        return answer;
    }
}