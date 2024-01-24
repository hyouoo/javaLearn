package codekatalv6;

import java.util.Arrays;

// 양궁대회
// https://school.programmers.co.kr/learn/courses/30/lessons/92342
// 입출력 예
//      n	info	                result
//      5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
//      1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
//      9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
//      10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]
public class Q137 {
    public static void main(String[] args) {
        int n = 1;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        Solution137 solution = new Solution137();
        System.out.println(Arrays.toString(solution.solution(n, info)));
    }
}

class Solution137 {
    int len, numArrow;
    int[] apeache, ryan;
    int maxDiff = 0;
    int[] result;

    public int[] solution(int n, int[] info) {
        len = info.length;
        apeache = info;
        ryan = new int[len];
        numArrow = n;
        result = new int[len];

        dfs(0, 0);

        return maxDiff == 0 ? new int[] {-1} : result;
    }

    private void dfs(int used, int depth) {
        if (used == numArrow || depth == len) {
            int diff = getDiff(apeache, ryan);
            findMaxDiff(diff);
            return;
        }
        for (int i = depth; i < len; i++) {
            int arrow = apeache[i] + 1;
            if (used + arrow > numArrow) {
                if (i == len - 1) {
                    arrow = numArrow - used;
                } else {
                    continue;
                }
            }
            ryan[i] += arrow;
            dfs(used + arrow, i + 1);
            ryan[i] -= arrow;
        }
    }

    private void findMaxDiff(int diff) {
        if (diff > maxDiff) {
            maxDiff = diff;
            result = ryan.clone();
        } else if (diff == maxDiff) {
            for (int i = len - 1; i >= 0; i--) {
                if (ryan[i] > result[i]) {
                    result = ryan.clone();
                    break;
                } else if (ryan[i] < result[i]) break;
            }
        }
    }

    private int getDiff(int[] apeache, int[] ryan) {
        int scoreApeach = 0, scoreRyan = 0;
        for (int i = 0; i < len; i++) {
            if (apeache[i] == 0 && ryan[i] == 0) continue;
            if (apeache[i] >= ryan[i]) {
                scoreApeach += 10 - i;
            } else {
                scoreRyan += 10 - i;
            }
        }
        return scoreRyan - scoreApeach;
    }
}
