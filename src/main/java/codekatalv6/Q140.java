package codekatalv6;

// 유사 칸토어 비트열
// https://school.programmers.co.kr/learn/courses/30/lessons/148652
// 입출력 예
//      n	l	r	result
//      2	4	17	8
public class Q140 {
    public static void main(String[] args) {
        int n = 2;
        long l = 4, r = 17;
        Solution140 solution = new Solution140();
        System.out.println(solution.solution(n, l, r));
    }
}

class Solution140 {
    public int solution(int n, long l, long r) {
        return countOne(n, l, r, 1);
    }

    public int countOne(int n, long l, long r, long idx) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        long part = (long) Math.pow(5, n - 1);
        for (int i = 0; i < 5; i++) {
            if (i == 2 || (idx + part * (i + 1) - 1) < l || r < (idx + part * i)) continue;
            count += countOne(n - 1, l, r, idx + part * i);
        }
        return count;
    }
}

class Solution140Alt {
    public int solution(int n, long l, long r) {
        long answer = r - l + 1;
        for (long i = l - 1; i <= r - 1; i++) {
            for (int j = 0; j < n; j++) {
                if ((i / (int) Math.pow(5, j)) % 5 == 2) {
                    answer--;
                    break;
                }
            }
        }
        return (int) answer;
    }
}