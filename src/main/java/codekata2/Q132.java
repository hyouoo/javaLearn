package codekata2;

import java.util.*;

// 과제 진행하기
// https://school.programmers.co.kr/learn/courses/30/lessons/176962
// 입출력 예
//      plans	                                                                                                            result
//      [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]	                                ["korean", "english", "math"]
//      [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
//      [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]	                                        ["bbb", "ccc", "aaa"]
public class Q132 {
    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        Solution132 solution = new Solution132();
        System.out.println(Arrays.toString(solution.solution(plans)));
    }
}

class Solution132 {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparing(o -> o[1]));
        Stack<String[]> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < plans.length - 1; i++) {
            String[] cur = plans[i];
            String[] next = plans[i + 1];
            int curStart = getMinutes(cur[1]);
            int curEnd = curStart + Integer.parseInt(cur[2]);
            int nextStart = getMinutes(next[1]);

            if (curEnd > nextStart) {
                cur[2] = String.valueOf(curEnd - nextStart);
                stack.push(cur);
                continue;
            }

            answer.add(cur[0]);

            int available = nextStart - curEnd;
            while (!stack.isEmpty()) {
                int remain = Integer.parseInt(stack.peek()[2]);
                if (remain > available) {
                    stack.peek()[2] = String.valueOf(remain - available);
                    break;
                }
                available -= Integer.parseInt(stack.peek()[2]);
                answer.add(stack.pop()[0]);
            }
        }
        answer.add(plans[plans.length - 1][0]);
        while (!stack.isEmpty()) answer.add(stack.pop()[0]);
        return answer.toArray(new String[0]);
    }

    private int getMinutes(String time) {
        String[] sp = time.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }
}