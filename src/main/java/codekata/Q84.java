package codekata;

import java.util.Stack;

// 괄호 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/76502
// 입출력 예
//        s	        result
//        "[](){}"	3
//        "}]()[{"	2
//        "[)(]"	0
//        "}}}"	    0
public class Q84 {
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt((i + j) % s.length());
                if (stack.isEmpty() || !isValidPair(stack.peek(), c)) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                count++;
            } else {
                stack.clear();
            }
        }
        return count;
    }

    private static boolean isValidPair(Character peek, char c) {
        return  (peek == '(' && c == ')' || peek == '{' && c == '}' || peek == '[' && c == ']');
    }
}
