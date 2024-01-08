package codekata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 거리두기 확인하기
// https://school.programmers.co.kr/learn/courses/30/lessons/81302
// 입출력 예
//        places	result
//        [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
//        ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
//        ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
//        [1, 0, 1, 1, 1]
public class Q118 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Solution118 solution = new Solution118();
        System.out.println(Arrays.toString(solution.solution(places)));
    }
}

class Solution118 {
    final int LEN = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[LEN];

        for (int i = 0; i < LEN; i++) {
            String[] place = places[i];

            boolean isOk = true;
            for (int r = 0; r < LEN && isOk; r++) {
                for (int c = 0; c < LEN && isOk; c++) {
                    if (place[r].charAt(c) == 'P') {
                        isOk = bfs(r, c, place);
                    }
                }
            }
            answer[i] = isOk ? 1 : 0;
        }
        return answer;
    }

    private boolean bfs(int r, int c, String[] place) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= LEN || nc >= LEN || (nr == r && nc == c)) continue;

                int distance = Math.abs(nr - r) + Math.abs(nc - c);
                if (place[nr].charAt(nc) == 'O' && distance < 2)
                    q.add(new int[]{nr, nc});
                if (place[nr].charAt(nc) == 'P' && distance <= 2)
                    return false;
            }
        }
        return true;
    }
}