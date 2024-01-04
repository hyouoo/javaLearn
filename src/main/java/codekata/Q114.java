package codekata;

// 배달
// https://school.programmers.co.kr/learn/courses/30/lessons/12978
// 입출력 예
//        N	road	                                                    K	result
//        5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	        3	4
//        6	[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]	4	4
public class Q114 {
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;
        Solution114 solution = new Solution114();
        System.out.println(solution.solution(N, road, K));
    }
}

class Solution114 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0, MAX = 50 * 10000 + 1;
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                map[i][j] = MAX;
            }
        }
        for (int[] root : road) {
            if (map[root[0]][root[1]] < root[2]) continue;
            map[root[0]][root[1]] = root[2];
            map[root[1]][root[0]] = root[2];
        }
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                for (int k = 1; k <= N; k++) {
                    if (map[i][k] > map[i][j] + map[j][k])
                        map[i][k] = map[i][j] + map[j][k];
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K) answer++;
        }
        return answer;
    }
}