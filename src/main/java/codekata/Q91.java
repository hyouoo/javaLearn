package codekata;

import java.util.*;

// 기능 개발
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 입출력 예
//          progresses	                speeds	            return
//          [93, 30, 55]	            [1, 30, 5]	        [2, 1]
//          [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
public class Q91 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            progressQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

        int days = 0, count = 0;
        List<Integer> result = new ArrayList<>();
        while (!progressQueue.isEmpty() && !speedQueue.isEmpty()) {
            if (progressQueue.peek() + days * speedQueue.peek() >= 100) {
                progressQueue.poll();
                speedQueue.poll();
                count++;
            } else {
                if (count != 0) {
                    result.add(count);
                    count = 0;
                }
                days++;
            }
        }
        result.add(count);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
