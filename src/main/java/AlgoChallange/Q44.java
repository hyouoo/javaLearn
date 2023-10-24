package AlgoChallange;

import java.time.LocalDate;

// 2016년
// 문제 설명
//        2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
//        요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
//        예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
// 제한 조건
//        2016년은 윤년입니다.
//        2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
// 입출력 예
//        a	b	result
//        5	24	"TUE"
public class Q44 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
        System.out.println(solution2(a, b));
    }

    private static String solution(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // a월의 전달까지 days숫자를 더하고 b를 더해서 총일수를 구한다.
        int today = 0;
        for (int i = 0; i < a-1; i++) {
            today += days[i];
        }
        today += b;
        // 7로 나눈 나머지에 따라 요일을 반환한다
        return day[today % 7];
    }

    private static String solution2(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }

}
