package AlgoChallange;

import java.util.*;

// 신고 결과 받기
// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// 입출력 예
//        id_list	                            report	                                                            k	result
//        ["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
//        ["con", "ryan"]	                    ["ryan con", "ryan con", "ryan con", "ryan con"]	                3	[0,0]
public class Q64 {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    // 각 id_list의 String으로 map의 key를 구성
    // 신고당한 회수(Integer), 신고한 사람(리스트) 을 map으로 만들어서 상위 map의 value에 지정
    // report의 각 원소마다 " "로 구분하여 index 1과 일치하는 key를 찾아 신고횟수 증가 및 신고한 사람 리스트 추가
    // map[key][key] 값이 k이상이면 map[key][value] list를 호출
    // 리스트의 이름과 일치하는 유저에게 메일 발송 횟수++
    private static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> result = new LinkedHashMap<>();

        for (String s : id_list) {
            reportMap.put(s, new HashSet<>());
            result.put(s, 0);
        }
        for (String s : report) {
            String[] split = s.split(" ");
            reportMap.get(split[1]).add(split[0]);
        }

        for (Map.Entry<String, Set<String>> entry: reportMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String plaintiff : entry.getValue()) {
                    result.put(plaintiff, result.get(plaintiff) + 1);
                }
            }
        }
        return result.values().stream().mapToInt(Integer::intValue).toArray();
    }
}
