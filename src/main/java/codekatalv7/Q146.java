package codekatalv7;

import java.util.*;

// 베스트앨범
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
// 입출력 예
//      genres	                                        plays	                    return
//      ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
public class Q146 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic"};
        int[] plays = {800, 600, 150, 800};
        Solution146 sol = new Solution146();
        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }
}
// 결과값을 반환할 List<Integer> 정의 -> array로 변환하여 반환
// genre별 재생시간을 합산한 Map 정의, genre내 노래별 idx와 재생시간을 담을 Map 정의
// genre별 재생횟수를 더하여 sorting, genre내 노래의 재생횟수로 sorting
// 2개까지 list에 add
class Solution146 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> totalPlay = new HashMap<>();
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> currentMap = map.getOrDefault(genres[i], new HashMap<>());
            currentMap.put(i, plays[i]);
            map.put(genres[i], currentMap);
        }

        List<String> sortedGenre = new ArrayList<>(totalPlay.keySet());
        sortedGenre.sort((o1, o2) -> totalPlay.get(o2) - totalPlay.get(o1));

        for (String genre : sortedGenre) {
            Map<Integer, Integer> song = map.get(genre);
            List<Integer> sortedSong = new ArrayList<>(song.keySet());
            sortedSong.sort((o1, o2) -> song.get(o2) - song.get(o1));

            for (int i = 0; i < Math.min(sortedSong.size(), 2); i++) {
                answer.add(sortedSong.get(i));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}