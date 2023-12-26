package codekata;

// 택배상자
// https://school.programmers.co.kr/learn/courses/30/lessons/131704
// 입출력 예
//        order	            result
//        [4, 3, 1, 2, 5]	2
//        [5, 4, 3, 2, 1]	5

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q106 {
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        Solution106 solution = new Solution106();
        System.out.println(solution.solution(order));
    }
}

class Solution106 {
    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> orderQ = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < order.length + 1; i++) {
            queue.add(i);
            orderQ.add(order[i - 1]);
        }
        int count = 0;
        boolean flag = true;
        while (!orderQ.isEmpty() && flag) {
            if (orderQ.peek().equals(queue.peek())) {
                queue.poll();
                orderQ.poll();
                count++;
            } else if (!stack.isEmpty() && orderQ.peek().equals(stack.peek())) {
                stack.pop();
                orderQ.poll();
                count++;
            } else if (!queue.isEmpty()) {
                stack.add(queue.poll());
            } else {
                flag = false;
            }
        }
        return count;
    }
}