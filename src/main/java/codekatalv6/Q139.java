package codekatalv6;

// 택배 배달과 수거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/150369
// 입출력 예
//      cap	n	deliveries	            pickups	                result
//      4	5	[1, 0, 3, 1, 2]	        [0, 3, 0, 4, 0]	        16
//      2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
public class Q139 {
    public static void main(String[] args) {
        int cap = 4, n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 5, 4, 0};
        Solution139 solution = new Solution139();
        System.out.println(solution.solution(cap, n, deliveries, pickups));
    }
}

class Solution139 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivered = 0, pickedup = 0;

        for (int i = n; i > 0; i--) {
            delivered -= deliveries[i - 1];
            pickedup -= pickups[i - 1];
            while (delivered < 0 || pickedup < 0) {
                answer += (long) i * 2;
                delivered += cap;
                pickedup += cap;
            }
        }
        return answer;
    }
}