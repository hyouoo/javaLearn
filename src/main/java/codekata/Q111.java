package codekata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 무인도 여행
// https://school.programmers.co.kr/learn/courses/30/lessons/154540
// 입출력 예
//        maps	                                result
//        ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
//        ["XXX","XXX","XXX"]	                [-1]
public class Q111 {
    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        Solution111 solution = new Solution111();
        System.out.println(Arrays.toString(solution.solution(maps)));
    }
}

class Solution111 {

    boolean[][] visited;
    char[][] map;

    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int dur = dfs(i, j);
                if (dur > 0) answer.add(dur);
            }
        }
        Collections.sort(answer);
        return answer.isEmpty()? new int[] {-1} : answer.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) return 0;
        if (visited[x][y]) return 0;
        if (map[x][y] == 'X') return 0;

        int res = map[x][y] - '0';
        visited[x][y] = true;

        res += dfs(x, y + 1);
        res += dfs(x + 1, y);
        res += dfs(x - 1, y);
        res += dfs(x, y - 1);

        return res;
    }
}