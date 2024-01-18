package codekatalv6;

import java.util.Arrays;
// N-Queen
// https://school.programmers.co.kr/learn/courses/30/lessons/12952
// 입출력 예
//      n	result
//      4	2
// dfs
public class Q131 {
    public static void main(String[] args) {
        int n = 4;
        Solution131 solution = new Solution131();
        System.out.println(solution.solution(n));
    }
}

class Solution131 {
    int[] visited;
    int answer;

    public int solution(int n) {
        answer = 0;
        visited = new int[n];
        Arrays.fill(visited, -1);
        dfs(0, n);
        return answer;
    }

    private void dfs(int row, int n) {
        if (row >= n) {
            answer++;
            return;
        }
        for (int col = 0; col < n; col++) {
            visited[row] = col;
            if (placeable(row)) dfs(row + 1, n);
        }
    }

    private boolean placeable(int row) {
        for (int nth = 0; nth < row; nth++) {
            if (visited[nth] == visited[row] || row - nth == Math.abs(visited[nth] - visited[row])) return false;
        }
        return true;
    }
}