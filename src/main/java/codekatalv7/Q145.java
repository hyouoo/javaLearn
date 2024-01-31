package codekatalv7;

// 단어 변환
// https://school.programmers.co.kr/learn/courses/30/lessons/43163
// 입출력 예
//      begin	target	words	                                    return
//      "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
//      "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	        0
public class Q145 {
    public static void main(String[] args) {
        String begin = "hit", target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Solution145 sol = new Solution145();
        System.out.println(sol.solution(begin, target, words));
    }
}

// target이 words 안에 없으면 0 return
// dfs로 탐색, depth의 최소값이 답
// target 단어부터 시작, 하나의 alphabet이 다르면 dfs 탐색
// begin을 만나면 depth return
class Solution145 {

    String begin;
    String[] words;
    int len;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.words = words;
        len = words.length;
        boolean[] checked = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (words[i].equals(target)) dfs(0, i, target, checked);
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(int depth, int idx, String word, boolean[] checked) {
        if (hasOnlyOneDiff(word, begin)) {
            answer = Math.min(answer, depth + 1);
            return;
        }
        checked[idx] = true;
        for (int i = 0; i < len; i++) {
            if (!checked[i] && hasOnlyOneDiff(words[i], word)) dfs(depth + 1, i, words[i], checked);
        }
    }

    private boolean hasOnlyOneDiff(String st1, String st2) {
        int diff = 0;
        for (int i = 0; i < st1.length(); i++) {
            if (st1.charAt(i) != st2.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}