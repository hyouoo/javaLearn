package AlgoChallange;

// 숫자 짝꿍
// 문제 설명
//        두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
//        (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다.
//        X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
//        예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
//        다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
//        (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
//        두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
// 제한사항
//        3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
//        X, Y는 0으로 시작하지 않습니다.
//        X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
// 입출력 예
//        X	        Y	        result
//        "100"	    "2345"	    "-1"
//        "100"	    "203045"	"0"
//        "100"	    "123450"	"10"
//        "12321"	"42531"	    "321"
//        "5525"	"1255"	    "552"
public class Q53 {
    public static void main(String[] args) {
        String X = "100", Y = "2345";
        System.out.println(solution(X, Y));
        System.out.println(solution2(X, Y));
    }

    // "9" -> "0" 순서로 조회하면서 X, Y 두 개가 모두 포함하면 String append
    // 실행 시간 초과 발생
    private static String solution(String X, String Y) {
        StringBuilder result = new StringBuilder();
        String[] checker = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
        for (String ck : checker) {
            while (true) {
                if (X.contains(ck) && Y.contains(ck)) {
                    result.append(ck);
                    X = X.replaceFirst(ck, "");
                    Y = Y.replaceFirst(ck, "");
                } else {
                    break;
                }
            }
        }
        if (result.toString().startsWith("0")) return "0";
        if (result.toString().isEmpty()) return "-1";
        return result.toString();
    }

    private static String solution2(String X, String Y) {
        StringBuilder result = new StringBuilder();
        String[] checker = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};

        for (String ck : checker) {
            int countX = X.length() - X.replace(ck, "").length();
            int countY = Y.length() - Y.replace(ck, "").length();
            result.append(ck.repeat(Math.min(countX, countY)));
        }
        String resultStr = result.toString();
        if (resultStr.startsWith("0")) return "0";
        return resultStr.isEmpty() ? "-1" : resultStr;
    }
}