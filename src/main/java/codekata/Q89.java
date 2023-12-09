package codekata;

import java.util.HashMap;
import java.util.Map;

// 할인 행사
// https://school.programmers.co.kr/learn/courses/30/lessons/131127
// 입출력 예
//        want	                                        number	        discount	                                                                                                                    result
//        ["banana", "apple", "rice", "pork", "pot"]	[3, 2, 2, 2, 1]	["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]	3
//        ["apple"]	                                    [10]	        ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]	                        0
public class Q89 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want, number, discount));
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < number.length; i++) {
            map.put(want[i], number[i]);
        }
        Map<String, Integer> discountMap = new HashMap<>();
        int idx = -1, count = 0;
        boolean flag;
        while (idx < discount.length - 10) {
            flag = true;
            idx++;
            for (int i = idx; i < idx + 10; i++) {
                discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
            }
            for (String key : map.keySet()) {
                if (!map.get(key).equals(discountMap.get(key))) {
                    flag = false;
                    break;
                }
            }
            discountMap.clear();
            if (flag) count++;
        }
        return count;
    }
}
