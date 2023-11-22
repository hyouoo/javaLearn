package AlgoChallange;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 개인정보 수집 유효기간
// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// 입출력 예
//        today	        terms	                privacies	                                                                        result
//        "2022.05.19"	["A 6", "B 12", "C 3"]  ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]                    [1, 3]
//        "2020.01.01"	["Z 3", "D 5"]          ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
public class Q61 {
    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(solution2(today, terms, privacies)));
    }

    // privacies의 날짜에 코드별 유효기한을 더한 날짜를 확인하고 오늘 날짜와 비교해서 폐기 여부 결정
    // 그냥 일수는 안 건드리고 월과 년만 조정한 후 String.compareTo 메서드의 부등호로 처리?
    private static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> lst = new ArrayList<>();
        int newYear = 0, newMonth = 0, newDay = 0;

        String[] spliToday = today.split("\\.");
        int[] toDate = new int[spliToday.length];
        for (int i = 0; i < toDate.length; i++) {
            toDate[i] = Integer.parseInt(spliToday[i]);
        }
        LocalDate toDay = LocalDate.of(toDate[0], toDate[1], toDate[2]);

        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String[] strDate = splitPrivacy[0].split("\\.");
            int[] date = new int[strDate.length];
            for (int j = 0; j < date.length; j++) {
                date[j] = Integer.parseInt(strDate[j]);
            }

            for (String term : terms) {
                String[] spliTerm = term.split(" ");
                if (splitPrivacy[1].equals(spliTerm[0])) {
                    newMonth = date[1] + Integer.parseInt(spliTerm[1]);
                    newYear = date[0] + newMonth / 12;
                    newMonth = ((newMonth - 1) % 12) + 1;
                    if (date[2] - 1 == 0) {
                        if (newMonth - 1 == 0) {
                            newYear--;
                            newMonth = 12;
                        } else {
                            newMonth--;
                        }
                        newDay = 28;
                    } else {
                        newDay = date[2] - 1;
                    }
                    LocalDate endDate = LocalDate.of(newYear, newMonth, newDay);
                    if (toDay.isAfter(endDate)) {
                        lst.add(i + 1);
                        break;
                    }
                }
            }
        }
        int[] answer = new int[lst.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = lst.get(i);
        }
        return answer;
    }

    // 2000년 1월 1일을 day 0으로 보관이 시작된 날에서 기한까지 더한 후에 연도로 변환
    // 1개월이면 28이고, 1/28일을 반환 -> 1개월 : 28 : 2000.01.28, 2개월 > 56 > 2000.02.28
    public static int[] solution2(String today, String[] terms, String[] privacies) {
        int daysCollect = 0;
        int daysDispose = 0;
        int daysToday = calculateDays(today);
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            daysCollect = calculateDays(splitPrivacy[0]);

            for (String term : terms) {
                String[] splitTerm = term.split(" ");
                if (splitPrivacy[1].equals(splitTerm[0])) {
                    daysDispose = daysCollect + Integer.parseInt(splitTerm[1]) * 28;
                    break;
                }
            }

            if (daysDispose < daysToday) {
                lst.add(i + 1);
            }
        }

        int[] answer = new int[lst.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = lst.get(i);
        }
        return answer;
    }

    public static int calculateDays(String day) {
        String[] split = day.split("\\.");
        int[] toInt = new int[split.length];

        for (int i = 0; i < toInt.length; i++) {
            toInt[i] = Integer.parseInt(split[i]);
        }
        return (toInt[0] - 2000) * 28 * 12 + (toInt[1] - 1) * 28 + toInt[2];
    }
}
