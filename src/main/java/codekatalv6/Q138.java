package codekatalv6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 교점에 별 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/87377
// 입출력 예
//      line	                                                            result
//      [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]	    ["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
//      [[0, 1, -1], [1, 0, -1], [1, 0, 1]]	                                ["*.*"]
//      [[1, -1, 0], [2, -1, 0]]	                                        ["*"]
//      [[1, -1, 0], [2, -1, 0], [4, -1, 0]]	                            ["*"]
public class Q138 {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        Solution138 solution = new Solution138();
        System.out.println(Arrays.toString(solution.solution(line)));
    }
}

class Solution138 {
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        int len = line.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                long[] cross = getCross(line[i], line[j]);
                if (cross != null) list.add(cross);
            }
        }
        long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;
        for (long[] coordinates : list) {
            maxX = Math.max(coordinates[0], maxX);
            minX = Math.min(coordinates[0], minX);
            maxY = Math.max(coordinates[1], maxY);
            minY = Math.min(coordinates[1], minY);
        }
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '.';
            }
        }
        for (long[] cross : list) {
            map[(int) (maxY - cross[1])][(int) (cross[0] - minX)] = '*';
        }
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = String.valueOf(map[i]);
        }
        return answer;
    }

    private long[] getCross(int[] lineA, int[] lineB) {
        long det = (long) lineA[0] * lineB[1] - (long) lineA[1] * lineB[0];
        if (det == 0) return null;
        long x = (long) lineA[1] * lineB[2] - (long) lineA[2] * lineB[1];
        long y = (long) lineA[2] * lineB[0] - (long) lineA[0] * lineB[2];
        return x % det == 0 && y % det == 0 ? new long[]{x / det, y / det} : null;
    }
}