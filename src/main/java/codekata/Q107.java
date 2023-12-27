package codekata;

import java.util.*;

// 큰 수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/42883
// 입출력 예
//        number	    k	return
//        "1924"	    2	"94"
//        "1231234"	    3	"3234"
//        "4177252841"	4	"775841"
public class Q107 {
    public static void main(String[] args) {
        String number = "4321";
        int k = 1;
        Solution107 solution = new Solution107();
        System.out.println(solution.solution(number, k));
    }
}

class Solution107 {
    public String solution(String number, int k) {
        int[] numbers = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        for (int num : numbers) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            while (k > 0) {
                stack.pop();
                k--;
            }
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}