package codekata2;

import java.util.LinkedList;
import java.util.Queue;

// 리코쳇 로봇
// https://school.programmers.co.kr/learn/courses/30/lessons/169199
// 입출력 예
//      board	                                                result
//      ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]	7
//      [".D.R", "....", ".G..", "...D"]	                    -1
public class Q127 {
    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        Solution127 solution = new Solution127();
        System.out.println(solution.solution(board));
    }
}

class Solution127 {

    int row, col;
    int[] start;
    boolean[][] visited;
    String[] boardMap;

    public int solution(String[] board) {
        row = board.length;
        col = board[0].length();
        visited = new boolean[row][col];
        boardMap = new String[row];
        boolean find = false;

        for (int i = 0; i < row; i++) {
            boardMap[i] = board[i];
            if (find) continue;
            for (int j = 0; j < col; j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new int[]{i, j, 0};
                    find = true;
                    break;
                }
            }
        }
        return bfs(start);
    }

    private int bfs(int[] start) {
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int move = cur[2];

            if (boardMap[r].charAt(c) == 'G') return move;

            for (int i = 0; i < 4; i++) {
                int[] next = slide(cur, direction[i]);
                if (visited[next[0]][next[1]]) continue;
                visited[next[0]][next[1]] = true;
                q.add(new int[]{next[0], next[1], move + 1});
            }
        }
        return -1;
    }

    private int[] slide(int[] cur, int[] dir) {
        int nextR = cur[0];
        int nextC = cur[1];
        while (true) {
            nextR += dir[0];
            nextC += dir[1];
            if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || boardMap[nextR].charAt(nextC) == 'D') {
                nextR -= dir[0];
                nextC -= dir[1];
                break;
            }
        }
        return new int[]{nextR, nextC};
    }
}