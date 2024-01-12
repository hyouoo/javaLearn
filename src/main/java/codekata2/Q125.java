package codekata2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 혼자 놀기의 달인
// https://school.programmers.co.kr/learn/courses/30/lessons/131130
// 입출력 예
//      cards	            result
//      [8,6,3,7,2,5,1,4]	12
public class Q125 {
    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        Solution125 solution = new Solution125();
        System.out.println(solution.solution(cards));
    }
}

class Solution125 {
    int[] box;

    public int solution(int[] cards) {
        final int LEN = cards.length;
        box = new int[LEN + 1];
        boolean[] opened = new boolean[LEN + 1];
        System.arraycopy(cards, 0, box, 1, LEN);
        List<Integer> result = new ArrayList<>();

        int next;
        for (int i = 1; i < LEN + 1; i++) {
            int cnt;
            if (!opened[i]) {
                next = i;
                cnt = getSize(next, opened);
                result.add(cnt);
            }
        }
        if (result.size() == 1) return 0;
        else {
            result.sort(Collections.reverseOrder());
            return result.get(0) * result.get(1);
        }
    }

    private int getSize(int start, boolean[] opened) {
        int size = 0;
        int next = box[start];
        while (!opened[next]) {
            opened[next] = true;
            size++;
            next = box[next];
        }
        return size;
    }
}