package codekata;

import java.util.Arrays;
import java.util.Stack;

// 뒤에 있는 큰 수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/154539
// 입출력 예
//        numbers	            result
//        [2, 3, 3, 5]	        [3, 5, 5, -1]
//        [9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
public class Q98 {
    public static void main(String[] args) {
        int[] numbers = {9, 3, 3, 5};
        Solution98 solution = new Solution98();
        System.out.println(Arrays.toString(solution.solution(numbers)));
    }
}

class Solution98 {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
