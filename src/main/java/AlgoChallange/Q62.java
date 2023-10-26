package AlgoChallange;

import java.util.Arrays;

// 달리기 경기
// https://school.programmers.co.kr/learn/courses/30/lessons/178871
// 입출력 예
//          players	                                callings	                    result
//          ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]  ["mumu", "kai", "mine", "soe", "poe"]
public class Q62 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    private static String[] solution(String[] players, String[] callings) {
        StringBuilder sb = new StringBuilder();
        for (String calling : callings) {
            for (int j = 0; j < players.length; j++) {
                if (calling.equals(players[j])) {
                    sb.append(players[j - 1]);
                    players[j - 1] = players[j];
                    players[j] = sb.toString();
                    sb.setLength(0);
                }
            }
        }
        return players;
    }
}
