package codekatalv6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 우박수열 정적분
// https://school.programmers.co.kr/learn/courses/30/lessons/134239
// 입출력 예
//      k	ranges	                        result
//      5	[[0,0],[0,-1],[2,-3],[3,-3]]	[33.0,31.5,0.0,-1.0]
//      3	[[0,0], [1,-2], [3,-3]]	        [47.0,36.0,12.0]
public class Q129 {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        Solution129 solution = new Solution129();
        System.out.println(Arrays.toString(solution.solution(k, ranges)));
    }
}

class Solution129 {
    List<Double> area = new ArrayList<>();

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int n = collatz(k);
        int start, end;

        for (int i = 0; i < ranges.length; i++) {
            start = ranges[i][0];
            end = n + ranges[i][1];
            if (start > end) answer[i] = -1.0;
            else if (start == end) answer[i] = 0.0;
            for (int j = start; j < end; j++) {
                answer[i] += area.get(j);
            }
        }
        return answer;
    }

    private int collatz(int k) {
        int count = 0;
        int past;
        while (k > 1) {
            past = k;
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            count++;
            area.add((double) (past + k) / 2);
        }
        return count;
    }
}