package codekatalv6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 하노이의 탑
// https://school.programmers.co.kr/learn/courses/30/lessons/12946
// 입출력 예
//          n	result
//          2	[ [1,2], [1,3], [2,3] ]
public class Q123 {
    public static void main(String[] args) {
        int n = 2;
        Solution123 solution = new Solution123();
        System.out.println(Arrays.deepToString(solution.solution(n)));
    }
}

class Solution123 {
    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        return list.toArray(int[][]::new);
    }

    private void hanoi(int num, int from, int mid, int to) {
        if (num == 0) return;
        hanoi(num - 1, from, to, mid);
        list.add(new int[]{from, to});
        hanoi(num - 1, mid, from, to);
    }
}