package AlgoChallange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// 달리기 경기
// https://school.programmers.co.kr/learn/courses/30/lessons/178871
// 입출력 예
//          players	                                callings	                    result
//          ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]  ["mumu", "kai", "mine", "soe", "poe"]
public class Q62 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution3(players, callings)));
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

    // keys 배열의 연산을 통해서 index의 최종 순위 결정
    private static String[] solution2(String[] players, String[] callings) {
        int[] keys = new int[players.length];
        String[] result = players;

        for (String calling : callings) {
            for (int i = 0; i < players.length; i++) {
                if (calling.equals(result[i])) {
                    keys[i] -= 1;
                    keys[i + keys[i]] += 1;
                    result[i + keys[i]] = players[i];
                    break;
                }
            }
        }

//        for (int i = 0; i < result.length; i++) {
//            result[i - keys[i]] = players[i];
//        }
        return result;
    }

    private static String[] solution3(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        Map<Integer, String> result = new HashMap<>();

        String[] finish = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
            result.put(i, players[i]);
        }

        for (String call : callings) {
            String temp = result.get(rank.get(call) - 1);
            rank.replace(call, rank.get(call) - 1);
            rank.replace(temp, rank.get(call) + 1);

            result.replace(rank.get(call), call);
            result.replace(rank.get(call) + 1, temp);
        }

        for (Entry<Integer, String> entry : result.entrySet()) {
            finish[entry.getKey()] = entry.getValue();
        }

        return finish;
    }
}
