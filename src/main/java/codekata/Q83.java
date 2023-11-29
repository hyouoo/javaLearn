package codekata;

// 귤 고르기
// https://school.programmers.co.kr/learn/courses/30/lessons/138476
// 입출력 예
//        k	tangerine	result
//        6	[1, 3, 2, 5, 4, 5, 2, 3]	3
//        4	[1, 3, 2, 5, 4, 5, 2, 3]	2
//        2	[1, 1, 1, 1, 2, 2, 2, 3]	1

public class Q83 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k, tangerine));

    }
    private static int solution(int k, int[] tangerine) {

        return k;
    }
}
