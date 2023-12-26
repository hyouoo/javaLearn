package codekata;

// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// 입출력 예
//        numbers	return
//        "17"	    3
//        "011"	    2

import java.util.HashSet;
import java.util.Set;

public class Q104 {
    public static void main(String[] args) {
        String numbers = "011";
        Solution104 solution = new Solution104();
        System.out.println(solution.solution(numbers));
    }
}

class Solution104 {
    public int solution(String numbers) {
        char[] parseNum = numbers.toCharArray();
        boolean[] visited = new boolean[parseNum.length];
        Set<Integer> result = new HashSet<>();
        makeNum(parseNum, visited, "", result);
        return result.size();
    }

    private void makeNum(char[] parseNum, boolean[] visited, String current, Set<Integer> result) {
        if (!current.isEmpty()){
            int num = Integer.parseInt(current);
            if (isPrime(num)) result.add(num);
        }

        for (int i = 0; i < parseNum.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNum(parseNum, visited, current + parseNum[i], result);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}