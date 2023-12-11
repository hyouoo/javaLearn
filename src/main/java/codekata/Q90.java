package codekata;

import java.util.HashMap;
import java.util.Map;

// 의상
// https://school.programmers.co.kr/learn/courses/30/lessons/42578
// 입출력 예
//        clothes	                                                                                    return
//        [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
//        [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	            3
public class Q90 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        int count = 1;
        for (Integer value : map.values()) {
            count *= value + 1;
        }
        return count - 1;
    }
}
