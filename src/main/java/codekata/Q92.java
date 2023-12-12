package codekata;

// 프로세스
// https://school.programmers.co.kr/learn/courses/30/lessons/42587
// 입출력 예
//        priorities	        location	return
//        [2, 1, 3, 2]	        2	        1
//        [1, 1, 9, 1, 1, 1]	0	        5

import java.util.*;

public class Q92 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    private static int solution(int[] priorities, int location) {
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : priorities) {
            pQ.add(n);
        }
        int order =0;
        while(!pQ.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if (!pQ.isEmpty() && pQ.peek() == priorities[i]) {
                    pQ.poll();
                    order++;
                    if (i == location) return order;
                }
            }
        }
        return 0;
    }
}
