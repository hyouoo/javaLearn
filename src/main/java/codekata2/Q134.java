package codekata2;

// 혼자서 하는 틱택토
// https://school.programmers.co.kr/learn/courses/30/lessons/160585
//입출력 예
//      board	                result
//      ["O.X", ".O.", "..X"]	1
//      ["OOO", "...", "XXX"]	0
//      ["...", ".X.", "..."]	0
//      ["...", "...", "..."]	1
public class Q134 {
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        Solution134 solution = new Solution134();
        System.out.println(solution.solution(board));
    }
}

class Solution134 {
    int len;
    String[] map;

    public int solution(String[] board) {
        len = board.length;
        map = new String[len];
        System.arraycopy(board, 0, map, 0, len);
        int cntO = 0, cntX = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i].charAt(j) == 'O') cntO++;
                if (board[i].charAt(j) == 'X') cntX++;
            }
        }
        if (cntO > len || cntX > len || cntO - cntX < 0 || cntO - cntX > 1) return 0;
        if ((win('O') && cntX >= cntO) || (win('X') && cntO > cntX)) return 0;

        return 1;
    }

    private boolean win(char x) {
        for (int i = 0; i < len; i++) {
            if (map[i].charAt(0) == x && map[i].charAt(1) == x && map[i].charAt(2) == x) return true;
            if (map[0].charAt(i) == x && map[1].charAt(i) == x && map[2].charAt(i) == x) return true;
        }
        return (map[0].charAt(0) == x && map[1].charAt(1) == x && map[2].charAt(2) == x) ||
                (map[0].charAt(2) == x && map[1].charAt(1) == x && map[2].charAt(0) == x);
    }
}