package codekata;

// 마법의 엘리베이터
// https://school.programmers.co.kr/learn/courses/30/lessons/148653
// 입출력 예
//        storey	result
//        16	    6
//        2554	    16
public class Q117 {
    public static void main(String[] args) {
        int storey = 2554;
        Solution117 solution = new Solution117();
        System.out.println(solution.solution(storey));
    }
}

class Solution117 {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int temp = storey % 10;
            storey /= 10;
            if (temp == 5) {
                if (storey % 10 >= 5) {
                    answer += 10 - temp;
                    storey++;
                } else {
                    answer += temp;
                }
            } else if (temp > 5) {
                answer += 10 - temp;
                storey++;
            } else {
                answer += temp;
            }
        }
        return answer;
    }
}