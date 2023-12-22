package codekata;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// 입출력 예
//        bridge_length	weight	truck_weights	                return
//        2	            10	    [7,4,5,6]	                    8
//        100	        100	    [10]	                        101
//        100	        100	    [10,10,10,10,10,10,10,10,10,10]	110
public class Q102 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        Solution102 solution = new Solution102();
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }
}

class Solution102 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        Queue<Integer> truck = new LinkedList<>();
        for (int num : truck_weights) {
            truck.add(num);
        }

        int time = 0;
        int bridge_sum, next_truck;
        while (!bridge.isEmpty()) {
            time++;
            bridge.poll();
            bridge_sum = !bridge.isEmpty() ? bridge.stream().reduce(0, Integer::sum) : 0;
            if (!truck.isEmpty()) {
                next_truck = truck.peek();
                if (bridge_sum + next_truck <= weight) {
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }
        return time;
    }
}
