package AlgoMarathon;

import java.util.HashMap;

// 숫자 문자열과 영단어
//        네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
//        다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
//        1478 → "one4seveneight"
//        234567 → "23four5six7"
//        10203 → "1zerotwozero3"
//        이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
//        s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
// 제한사항
//        1 ≤ s의 길이 ≤ 50
//        s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
//        return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
// 입출력 예
//        s	                    result
//        "one4seveneight"	    1478
//        "23four5six7"	        234567
//        "2three45sixseven"	234567
//        "123"	                123
public class Q36 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    private static final HashMap<String, String> dict = new HashMap<>() {{
        put("zero", "0");
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
    }};

    private static int solution(String s) {
        // 정규식을 이용하여 숫자와 문자를 구분
        String[] listS = s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        // 각 substring을 영단어와 매치 확인 후 숫자로 변환
        StringBuilder result = new StringBuilder();
        for (String str : listS) {
            if (Character.isDigit(str.charAt(0))) {
                result.append(str);
            }
            int sIndex = 0;
            int eIndex = 3; // 모든 키값의 길이가 3이상이므로 초기값을 3으로 설정
            while (eIndex <= str.length()) {
                String substring = str.substring(sIndex, eIndex);
                if (dict.containsKey(substring)) {
                    result.append(dict.get(substring));
                    sIndex = eIndex;
                } else {
                    eIndex++;
                }
            }
        }
        // 숫자로 만들어진 string을 parseint로 반환
        return Integer.parseInt(result.toString());
    }

    private static int solution2(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                currentWord.append(c); // o, on, one 순서로 append
                if (dict.containsKey(currentWord.toString())) {
                    result.append(dict.get(currentWord.toString()));
                    currentWord.setLength(0); // 길이를 0으로 만들어서 초기화
                }
            }
        }
        return Integer.parseInt(result.toString());
    }

    private static int solution3(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
