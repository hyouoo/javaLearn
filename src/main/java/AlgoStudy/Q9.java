package AlgoStudy;

// 정수 제곱근 판별
// 문제 설명
//        임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//        n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//
// 제한 사항
//        n은 1이상, 50,000,000,000,000 이하인 양의 정수입니다.
// 입출력 예
//        n	    return
//        121	144
//        3	    -1
public class Q9 {
    public static void main(String[] args) {
        long n = 144;
        System.out.println(Solution.solution(n));
        System.out.println(Solution.solution2(n));
    }

    private static class Solution {
        private static long solution(long n) {
            int sqrtToInt = (int) Math.sqrt(n);
            if (Math.sqrt(n) - sqrtToInt == 0) {
                return (long) Math.pow(sqrtToInt + 1, 2);
            }
            return -1;
        }

        private static long solution2(long n) {
            long sqrt = (long) Math.sqrt(n);
            return sqrt * sqrt == n ? (sqrt + 1) * (sqrt + 1) : -1;
        }
    }
}
