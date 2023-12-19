package codekata;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

// 주차 요금 계산
// https://school.programmers.co.kr/learn/courses/30/lessons/92341
// 입출력 예
//        fees	                records	                                                                                                                                                        result
//        [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
//        [120, 0, 60, 591]	    ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	                                                                            [0, 591]
//        [1, 461, 1, 10]	    ["00:00 1234 IN"]	                                                                                                                                            [14841]
public class Q96 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    private static int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> map = new TreeMap<>();
        for (String st : records) {
            String[] split = st.split(" ");
            map.computeIfAbsent(split[1], k -> new ArrayList<>()).add(split[0]);
        }
        List<Integer> durationList = new ArrayList<>();
        for (List<String> values : map.values()) {
            if (values.size() % 2 != 0) values.add("23:59");
            int i = 0;
            int totalDuration = 0;
            while (i < values.size()) {
                int dur = (int) Duration.between(LocalTime.parse(values.get(i)), LocalTime.parse(values.get(i + 1))).toMinutes();
                totalDuration += dur;
                i += 2;
            }
            durationList.add(totalDuration);
        }
        int[] feeArr = new int[map.size()];
        for (int i = 0; i < durationList.size(); i++) {
            if (durationList.get(i) < fees[0]) {
                feeArr[i] = fees[1];
            } else {
                int fee = fees[1] + (int) Math.ceil((durationList.get(i) - fees[0]) / (double) fees[2]) * fees[3];
                feeArr[i] = fee;
            }
        }
        return feeArr;
    }
}
