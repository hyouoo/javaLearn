package codekata;

// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// 입출력 예
//        numbers	        target	return
//        [1, 1, 1, 1, 1]	3	    5
//        [4, 1, 2, 1]	    4	    2
public class Q94 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        int depth = 0;
        int checker =0;
        dfs(numbers, target, depth, checker);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int depth, int checker) {
        if (depth == numbers.length) {
            if (checker == target) answer++;
        } else {
            dfs(numbers, target, depth + 1, checker + numbers[depth]);
            dfs(numbers, target, depth + 1, checker - numbers[depth]);
        }
    }
}
