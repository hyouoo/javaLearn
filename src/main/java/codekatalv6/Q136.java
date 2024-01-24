package codekatalv6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 요격 시스템
// https://school.programmers.co.kr/learn/courses/30/lessons/181188
// 입출력 예
//      targets	                                            result
//      [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]	3
public class Q136 {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        Solution136 solution = new Solution136();
        System.out.println(solution.solution(targets));
    }
}

class Solution136 {
    public int solution(int[][] targets) {
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        pq.addAll(Arrays.asList(targets));

        while (!pq.isEmpty()) {
            int idx = pq.poll()[1];
            while (!pq.isEmpty() && pq.peek()[0] < idx) pq.poll();
            count++;
        }
        return count;
    }
}