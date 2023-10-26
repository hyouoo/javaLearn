package AlgoChallange;

import java.time.LocalDate;
import java.util.Arrays;

// 개인정보 수집 유효기간
// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// 입출력 예
//        today	        terms	                privacies	                                                                        result
//        "2022.05.19"	["A 6", "B 12", "C 3"]  ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]                    [1, 3]
//        "2020.01.01"	["Z 3", "D 5"]          ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
public class Q61 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
//        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }

    // privacies의 날짜에 코드별 유효기한을 더한 날짜를 확인하고 오늘 날짜와 비교해서 폐기 여부 결정
    private static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int newYear = 0, newMonth = 0;


        for (String privacy : privacies) {
            String[] splitPrivacy = privacy.split(" ");
            String[] strDate = splitPrivacy[0].split("\\.");
            int[] date = new int[strDate.length];
            for (int i = 0; i < date.length; i++) {
                date[i] = Integer.parseInt(strDate[i]);
            }
            for (String term : terms) {
                String[] spliTerm = term.split(" ");
                if (splitPrivacy[1].equals(spliTerm[0])) {
                    LocalDate startDate = LocalDate.of(date[0], date[1], date[2]);
                    LocalDate endDate = startDate.plusDays(28L * Integer.parseInt(spliTerm[1]));

                    newMonth = Integer.parseInt(privacy.substring(5, 7)) + Integer.parseInt(spliTerm[1]);
                    newYear = Integer.parseInt(privacy.substring(0, 4)) + newMonth / 12;
                    newMonth = ((newMonth - 1) % 12) + 1;

                }

            }
        }

        return answer;
    }
}
