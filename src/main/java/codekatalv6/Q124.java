package codekatalv6;

import java.util.LinkedList;
import java.util.Queue;

// 미로 탈출
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// 입출력 예
//          maps	                                    result
//          ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	16
//          ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	-1
public class Q124 {
    public static void main(String[] args) {
        String[] maps = {"SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE"}; //8
        Solution124 solution = new Solution124();
        System.out.println(solution.solution(maps));
    }
}

class Solution124 {
    int R, C;
    boolean[][] visited;
    char[][] map;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int[] posS = new int[2];
        int[] posE = new int[2];
        int[] posL = new int[2];
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i].charAt(j) == 'S') posS = new int[]{i, j};
                if (maps[i].charAt(j) == 'L') posL = new int[]{i, j};
                if (maps[i].charAt(j) == 'E') posE = new int[]{i, j};
                map[i][j] = maps[i].charAt(j);
            }
        }
        int cntStoL = bfs(posS, posL);
        if (cntStoL < 0) return -1;
        int cntLtoE = bfs(posL, posE);
        if (cntLtoE < 0) return -1;

        return cntStoL + cntLtoE;
    }

    private int bfs(int[] from, int[] to) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{from[0], from[1], 0});
        visited = new boolean[R][C];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = cur[2];
            visited[curX][curY] = true;

            if (curX == to[0] && curY == to[1]) return cnt;

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C || visited[nX][nY] || map[nX][nY] == 'X') continue;

                visited[nX][nY] = true;
                q.add(new int[]{nX, nY, cnt + 1});
            }
        }
        return -1;
    }
}