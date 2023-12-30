package codekata;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/118667
// 입출력 예
//        queue1	    queue2	        result
//        [3, 2, 7, 2]	[4, 6, 5, 1]	2
//        [1, 2, 1, 2]	[1, 10, 1, 2]	7
//        [1, 1]	    [1, 5]	        -1
public class Q110 {
    public static void main(String[] args) {
        int[] queue1 = {1, 3};
        int[] queue2 = {1, 4};
        Solution110 solution = new Solution110();
        System.out.println(solution.solution(queue1, queue2));
    }
}

class Solution110 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        int answer = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (answer > queue1.length * 2) break;
            int val;
            if (sum1 > sum2) {
                val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            } else if (sum2 > sum1) {
                val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            } else {
                return answer;
            }
            answer++;
        }
        answer = -1;
        return answer;
    }
}