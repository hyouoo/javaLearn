package codekata;

import java.util.Arrays;

// 테이블 해시 함수
// https://school.programmers.co.kr/learn/courses/30/lessons/147354
// 입출력 예
//        data	                                col	row_begin	row_end	result
//        [[2,2,6],[1,5,10],[4,2,9],[3,8,3]]	2	2	        3	    4
public class Q122 {
    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2, row_begin = 2, row_end = 3;
        Solution122 solution = new Solution122();
        System.out.println(solution.solution(data, col, row_begin, row_end));
    }
}

class Solution122 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        col -= 1;
        row_begin -= 1;
        final int cri = col;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[cri] == o2[cri]) return o2[0] - o1[0];
            return o1[cri] - o2[cri];
        });
        for (int i = row_begin; i < row_end; i++) {
            final int moderator = i + 1;
            int eachSum = Arrays.stream(data[i]).map(val -> val % moderator).sum();
            answer = answer ^ eachSum;
        }
        return answer;
    }
}