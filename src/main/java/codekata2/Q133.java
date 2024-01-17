package codekata2;

// 조이스틱
// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// 입출력 예
//      name	    return
//      "JEROEN"	56
//      "JAN"	    23
public class Q133 {
    public static void main(String[] args) {
        String name = "JAN";
        Solution133 solution = new Solution133();
        System.out.println(solution.solution(name));
    }
}

class Solution133 {
    public int solution(String name) {
        int len = name.length();
        int count = 0, next;
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            char target = name.charAt(i);
            count += getCount(target);

            next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + (len - next) + Math.min(i, (len - next)));
        }
        return count + move;
    }

    private int getCount(char target) {
        if (target < 'N') return target - 'A';
        return 'Z' - target + 1;
    }
}