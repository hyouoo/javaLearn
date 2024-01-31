package codekatalv7;

// 네트워크
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
// 입출력 예
//      n	computers	                        return
//      3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
//      3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
public class Q144 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution144 sol = new Solution144();
        System.out.println(sol.solution(n, computers));
    }
}

// i node의 com과 연결된 j node의 com을 모두 조회 -> j node의 com과 연결된 com을 모두 조회 반복 (추가 연결이 없을 때까지)
// 추가 연결이 없으면 count 증가
class Solution144 {

    private int n;
    private int[][] coomputers;
    boolean[] added;

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.coomputers = computers;
        added = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!added[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node) {
        added[node] = true;
        for (int j = 0; j < n; j++) {
            if (node != j && !added[j] && coomputers[node][j] == 1)
                dfs(j);
        }
    }
}