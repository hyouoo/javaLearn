package codekata;

// 모음사전
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
// 입출력 예
//        word	    result
//        "AAAAE"	6
//        "AAAE"	10
//        "I"	    1563
//        "EIO"	    1189

import java.util.HashMap;
import java.util.Map;

public class Q97 {
    public static void main(String[] args) {
        String word = "AAAAE";
        Solution97 solution = new Solution97();
        System.out.println(solution.solution(word));
    }
}

class Solution97 {
    String[] vowels = {"A", "E", "I", "O", "U"};
    Map<String, Integer> map = new HashMap<>();
    Integer count = 0;

    public int solution(String word) {
        int depth = 0;
        String vowelWord = "";
        dfs(vowelWord, depth);

        return map.get(word);
    }

    private void dfs(String vowelWord, int depth) {
        map.put(vowelWord, count);
        count++;
        if (depth >= 5) return;
        for (String vowel : vowels) {
            dfs(vowelWord + vowel, depth + 1);
        }
    }
}
