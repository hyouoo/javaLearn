package codekata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 시소 짝꿍
// https://school.programmers.co.kr/learn/courses/30/lessons/152996
// 입출력 예
//        weights	            result
//        [100,180,360,100,270]	4
public class Q121 {
    public static void main(String[] args) {
        int[] weights = {100,180,360,100,270};
        Solution121 solution = new Solution121();
        System.out.println(solution.solution(weights));
    }
}

class Solution121 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();
        for (int weight : weights) {
            double self = weight * 1.0;
            double caseA = (weight * 2.0) / 3.0;
            double caseB = (weight * 2.0) / 4.0;
            double caseC = (weight * 3.0) / 4.0;
            if (map.containsKey(self)) answer += map.get(self);
            if (map.containsKey(caseA)) answer += map.get(caseA);
            if (map.containsKey(caseB)) answer += map.get(caseB);
            if (map.containsKey(caseC)) answer += map.get(caseC);
            map.put(self, map.getOrDefault(self, 0) + 1);
        }
        return answer;
    }
}