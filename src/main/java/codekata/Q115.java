package codekata;

// 호텔 대실
// https://school.programmers.co.kr/learn/courses/30/lessons/155651
// 입출력 예
//        book_time	                                                                                            result
//        [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]	3
//        [["09:10", "10:10"], ["10:20", "12:20"]]	                                                            1
//        [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	                                        3
public class Q115 {
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        Solution115 solution = new Solution115();
        System.out.println(solution.solution(book_time));
    }
}

class Solution115 {
    public int solution(String[][] book_time) {
        final int CLEAN = 10;
        final int DAY = 24 * 60 + CLEAN;
        int answer = 0;

        int[] timeTable = new int[DAY];
        for (String[] book : book_time) {
            timeTable[time(book[0])] += 1;
            timeTable[time(book[1]) + CLEAN] -= 1;
        }
        for (int i = 1; i < DAY; i++) {
            timeTable[i] += timeTable[i - 1];
            answer = Math.max(answer, timeTable[i]);
        }
        return answer;
    }

    private int time(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}