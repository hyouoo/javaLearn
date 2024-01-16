package codekata2;

import java.util.PriorityQueue;
import java.util.Queue;

// 디펜스 게임
// https://school.programmers.co.kr/learn/courses/30/lessons/142085
// 입출력 예
//      n	k	enemy	                result
//      7	3	[4, 2, 4, 5, 3, 3, 1]	5
//      2	4	[3, 3, 3, 3]	        4
public class Q128 {
    public static void main(String[] args) {
        int n = 2, k = 4;
        int[] enemy = {3, 3, 3, 3};
        Solution128 solution = new Solution128();
        System.out.println(solution.solution(n, k, enemy));
    }
}

class Solution128 {
    public int solution(int n, int k, int[] enemy) {
        int survivor = n;
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < enemy.length; i++) {
            survivor -= enemy[i];
            pq.add(enemy[i]);
            if (survivor < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    survivor += pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        return enemy.length;
    }
}