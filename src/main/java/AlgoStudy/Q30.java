package AlgoStudy;

import java.util.ArrayList;

// 3진법 뒤집기
// 문제 설명
//        자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
// 제한사항
//        n은 1 이상 100,000,000 이하인 자연수입니다.
// 입출력 예
//        n	    result
//        45	7
//        125	229
public class Q30 {
    public static void main(String[] args) {
        int n = 125;
        System.out.println(Solution.solution(n));
        System.out.println(Solution.solution2(n));
        System.out.println(Solution.solution3(n));
    }

    private static class Solution {
        private static int solution(int n) {
            ArrayList<Integer> list = new ArrayList<>();
            while (n > 0) {
                list.add(n % 3);
                n /= 3;
            }
            int result = 0;
            for (Integer num : list) {
                result = result * 3 + num;
            }
            return result;
        }

        private static int solution2(int n) {
            ArrayList<Integer> list = new ArrayList<>();
            while (n > 0) {
                list.add(n % 3);
                n /= 3;
            }
            return list.stream().reduce(0, (acc, num) -> acc * 3 + num);
        }

        private static int solution3(int n) {
            String list = "";
            while (n > 0) {
                list += n % 3;
                n /= 3;
            }
            return Integer.parseInt(list, 3); // parseInt(String, int) 3진수인 list를 10진수로 변환
        }
    }
}
