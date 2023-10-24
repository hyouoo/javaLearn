package AlgoStudy;

// 문자열 다루기 기본
// 문제 설명
//        문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
//        예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
// 제한 사항
//        s는 길이 1 이상, 길이 8 이하인 문자열입니다.
//        s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
// 입출력 예
//        s	        return
//        "a234"	false
//        "1234"	true
public class Q26 {
    public static void main(String[] args) {
        String s = "a234";
        System.out.println(solution(s));
        System.out.println(solution2(s));
        System.out.println(solution3(s));
    }

    private static boolean solution(String s) {
        char[] charS = s.toCharArray();
        if (s.length() == 4 || s.length() == 6) {
            for (char c : charS) {
                if (c < 48 || c > 57) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean solution2(String s) {
        return (s.length() == 4 || s.length() == 6) && s.chars().allMatch(Character::isDigit);
    }

    private static boolean solution3(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}
