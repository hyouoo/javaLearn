
package codekata;
// 멀쩡한 사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/62048
// 입출력 예
//        W	H	result
//        8	12	80
public class Q120 {
    public static void main(String[] args) {
        int W = 8, H = 12;
        Solution120 solution = new Solution120();
        System.out.println(solution.solution(W, H));
    }
}

class Solution120 {
    public long solution(int w, int h) {
        long total = (long) w * h;
        long deleted = w + h - gcd(w, h);
        return total - deleted;
    }

    private int gcd(int w, int h) {
        return h == 0 ? w : gcd(h, w % h);
    }
}