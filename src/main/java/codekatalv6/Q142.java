package codekatalv6;

import java.util.ArrayList;
import java.util.Arrays;

// 빛의 경로 사이클
// https://school.programmers.co.kr/learn/courses/30/lessons/86052
// 입출력 예
//      grid	    result
//      ["SL","LR"]	[16]
//      ["S"]	    [1,1,1,1]
//      ["R","R"]	[4,4]
public class Q142 {
    public static void main(String[] args) {
        String[] grid = {"SL", "LR"};
        Solution142 solution = new Solution142();
        System.out.println(Arrays.toString(solution.solution(grid)));
    }
}

// 시작 방법 정의, 4방향 순회 정의, 방문(방향 포함)기록 정의, 이동횟수 정의, 사이클 갯수 정의
// L, R 구현, 경계 작동방식 구현
class Solution142 {
    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        int R = grid.length;
        int C = grid[0].length();
        int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[R][C][direction.length];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int dir = 0; dir < direction.length; dir++) {
                    if (!visited[r][c][dir]) {
                        int cnt = 0;
                        while (!visited[r][c][dir]) {
                            cnt++;
                            visited[r][c][dir] = true;
                            if (grid[r].charAt(c) == 'L')
                                dir = dir == 0 ? 3 : dir - 1;
                            else if (grid[r].charAt(c) == 'R')
                                dir = dir == 3 ? 0 : dir + 1;
                            r = (r + direction[dir][0] + R) % R;
                            c = (c + direction[dir][1] + C) % C;
                        }
                        answer.add(cnt);
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(num -> num).toArray();
    }
}