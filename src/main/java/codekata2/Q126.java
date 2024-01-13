package codekata2;

import java.util.Arrays;

// 광물 캐기
// https://school.programmers.co.kr/learn/courses/30/lessons/172927
// 입출력 예
//      picks	    minerals	                                                                                                result
//      [1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	                            12
//      [0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	50
public class Q126 {
    public static void main(String[] args) {
        int[] picks = {0, 2, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron"};
        Solution126 solution = new Solution126();
        System.out.println(solution.solution(picks, minerals));
    }
}

class Solution126 {
    public int solution(int[] picks, String[] minerals) {
        int fatigue = 0;
        int countMine = Math.min(minerals.length / 5 + 1, Arrays.stream(picks).sum());
        int[][] fatigueMap = new int[countMine][3];
        for (int i = 0; i < countMine; i++) {
            for (int j = 5 * i; j < 5 * i + 5; j++) {
                if (j >= minerals.length) break;
                switch (minerals[j]) {
                    case "diamond" -> {
                        fatigueMap[i][0] += 1;
                        fatigueMap[i][1] += 5;
                        fatigueMap[i][2] += 25;
                    }
                    case "iron" -> {
                        fatigueMap[i][0] += 1;
                        fatigueMap[i][1] += 1;
                        fatigueMap[i][2] += 5;
                    }
                    case "stone" -> {
                        fatigueMap[i][0] += 1;
                        fatigueMap[i][1] += 1;
                        fatigueMap[i][2] += 1;
                    }
                }
            }
        }
        Arrays.sort(fatigueMap, (o1, o2) -> o2[2] - o1[2]);
        for (int i = 0, pick = 0; i < countMine; i++) {
            while (picks[pick] <= 0) pick++;
            fatigue += fatigueMap[i][pick];
            picks[pick]--;
        }
        return fatigue;
    }
}