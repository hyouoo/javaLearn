package codekatalv7;

import java.util.*;

// 이중우선순위큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42628
// 입출력 예
//      operations	                                                                return
//      ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	                [0,0]
//      ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
public class Q143 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        Solution143 sol = new Solution143();
        System.out.println(Arrays.toString(sol.solution(operations)));
    }
}

class Solution143 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch (op) {
                case "I" -> {
                    minPQ.add(num);
                    maxPQ.add(num);
                }
                case "D" -> {
                    if (maxPQ.isEmpty() || minPQ.isEmpty()) break;
                    if (num == 1) {
                        int max = maxPQ.poll();
                        minPQ.remove(max);
                    } else if (num == -1) {
                        int min = minPQ.poll();
                        maxPQ.remove(min);
                    }
                }
            }
        }
        if (maxPQ.isEmpty() || minPQ.isEmpty()) return new int[]{0, 0};
        return new int[]{maxPQ.poll(), minPQ.poll()};
    }
}