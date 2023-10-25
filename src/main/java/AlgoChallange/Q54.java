package AlgoChallange;

// 체육복
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
// 입출력 예
//        n	lost	reserve	    return
//        5	[2, 4]	[1, 3, 5]	5
//        5	[2, 4]	[3]	        4
//        3	[3]	    [1]	        2
public class Q54 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 5}, reserve = {3};
        System.out.println(solution(n, lost, reserve));
        System.out.println(solution2(n, lost, reserve));
    }

    // 전체 학생의 수만큼 배열을 만들고 lost인 학생은 -1, reserve 학생은 +1
    // 학생의 수가 -1이면 앞에 2가 있는지 확인하고 1을 가져옴, 없으면 뒤에 있는지 확인하고 1을 가져옴
    // 첫번째 학생이나 마지막 학생이 도둑맞은 경우 index out of range 에러 발생
    // 0인 학생을 카운트해서 반환
    private static int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        for (int l : lost) {
            student[l - 1]--;
        }
        for (int r : reserve) {
            student[r - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (student[i] == -1) {
                if (i > 0 && student[i - 1] == 1) {
                    student[i]++;
                    student[i - 1]--;
                } else if (i < n - 1 && student[i + 1] == 1) {
                    student[i]++;
                    student[i + 1]--;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (student[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    private static int solution2(int n, int[] lost, int[] reserve) {
        int[] student = new int[n + 2];
        int count = n;
        for (int l : lost) {
            student[l]--;
        }
        for (int r : reserve) {
            student[r]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (student[i] == -1) {
                if (student[i - 1] == 1) {
                    student[i]++;
                    student[i - 1]--;
                } else if (student[i + 1] == 1) {
                    student[i]++;
                    student[i + 1]--;
                } else {
                    count--;
                }
            }
        }
        return count;
    }
}
