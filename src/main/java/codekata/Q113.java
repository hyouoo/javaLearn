package codekata;

import java.util.LinkedList;
import java.util.Queue;

// 전력망을 둘로 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
// 입출력 예
//        n	wires	                                            result
//        9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
//        4	[[1,2],[2,3],[3,4]]	                                0
//        7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	            1
public class Q113 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        Solution113 solution = new Solution113();
        System.out.println(solution.solution(n, wires));
    }
}

class Solution113 {
    boolean[][] connected;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        connected = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            connected[wire[0]][wire[1]] = true;
            connected[wire[1]][wire[0]] = true;
        }
        for (int i = 0; i < wires.length; i++) {
            connected[wires[i][0]][wires[i][1]] = false;
            connected[wires[i][1]][wires[i][0]] = false;

            answer = Math.min(answer, bfs(n, i + 1));

            connected[wires[i][0]][wires[i][1]] = true;
            connected[wires[i][1]][wires[i][0]] = true;
        }
        return answer;
    }

    private int bfs(int n, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (connected[cur][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return Math.abs(n - 2 * cnt);
    }
}