package AlgoStudy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q14 {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        System.out.println(Solution.solution(seoul));
        System.out.println(Solution.solution2(seoul));
        System.out.println(Solution.solution3(seoul));
    }

    private static class Solution {
        private static String solution(String[] seoul) {
            for (int i = 0; i < seoul.length; i++) {
                if (seoul[i].matches("Kim")) {
                    return String.format("김서방은 %d에 있다", i);
                }
            }
            return "";
        }

        private static String solution2(String[] seoul) {
            int index = IntStream.range(0, seoul.length).filter(i -> seoul[i].matches("Kim"))
                    .findFirst().orElse(-1);
            return index != -1 ? String.format("김서방은 %d에 있다", index) : "";
        }

        private static String solution3(String[] seoul) {
            int index = Arrays.asList(seoul).indexOf("Kim");
            return "김서방은 " + index + "에 있다";
        }
    }
}
