package codekata;

public class Q93 {
    public static void main(String[] args) {
        int initialFatigue = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(findMaxDepth(initialFatigue, dungeons));
    }

    private static int findMaxDepth(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, dungeons, 0, visited);
    }

    private static int dfs(int fatigue, int[][] dungeons, int depth, boolean[] visited) {
        int maxDepth = depth;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= fatigue) {
                visited[i] = true;
                int updatedDepth = dfs(fatigue - dungeons[i][1], dungeons, depth + 1, visited);
                maxDepth = Math.max(maxDepth, updatedDepth);
                visited[i] = false;
            }
        }
        return maxDepth;
    }
}
