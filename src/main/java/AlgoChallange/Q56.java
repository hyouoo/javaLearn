package AlgoChallange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 대충 만든 자판
// https://school.programmers.co.kr/learn/courses/30/lessons/160586
// 입출력 예
//      keymap	            targets	        result
//      ["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
//      ["AA"]	            ["B"]	        [-1]
//      ["AGZ", "BSSS"]	    ["ASA","BGZ"]	[4, 6]
public class Q56 {
    public static void main(String[] args) {
        String[] keymap = {"AA"}, targets = {"B"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
        System.out.println(Arrays.toString(solution2(keymap, targets)));
    }

    // targets의 각 string에 대해, string의 각 char가 keymap의 각 string의 몇 번째에 있는지 확인, 최소값을 반환
    // 1이 나오면 break하고 1을 반환;
    // 각 char의 최소값을 모두 더하여 결과값 생성
    private static int[] solution(String[] keymap, String[] targets) {
        int[] tmp = new int[keymap.length];
        ArrayList<Integer> tmpResult = new ArrayList<>();
        int[] result = new int[targets.length];
        int k = 0;
        boolean foundOne = false;

        for (String t : targets) {
            for (int i = 0; i < t.length(); i++) {
                Arrays.fill(tmp, 100);
                for (int j = 0; j < keymap.length; j++) {
                    if (keymap[j].contains(t.subSequence(i, i))) {
                        tmp[j] = keymap[j].indexOf(t.charAt(i)) + 1;
                        if (tmp[j] == 1) {
                            tmpResult.add(1);
                            foundOne = true;
                            break;
                        }
                    }
                }
                if (foundOne) {
                    foundOne = false;
                    continue;
                }
                Arrays.sort(tmp);
                tmpResult.add(tmp[0] == 0 ? -1 : tmp[0]);
            }
            int sumResult = 0;
            for (Integer num : tmpResult) {
                sumResult += num;
            }
            result[k] = sumResult;
            tmpResult.clear();
            k++;
        }
        return result;
    }

    private static int[] solution2(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];

        for (int k = 0; k < targets.length; k++) {
            String target = targets[k];
            int sumResult = 0;

            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                int minDistance = Integer.MAX_VALUE;

                for (String row : keymap) {
                    int index = row.indexOf(c);
                    if (index != -1) {
                        minDistance = Math.min(minDistance, index + 1);
                    }
                }

                if (minDistance == Integer.MAX_VALUE) {
                    sumResult = -1;
                    break;
                } else {
                    sumResult += minDistance;
                }
            }
            result[k] = sumResult;
        }
        return result;
    }

    public int[] solution3(String[] keymap, String[] targets) {
        int[] minTouch = new int['Z' - 'A' + 1];
        Arrays.fill(minTouch, 200);
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int keyIndex = key.charAt(i) - 'A';
                minTouch[keyIndex] = Math.min(minTouch[keyIndex], i + 1);
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean canMake = true;
            for (int j = 0; j < target.length(); j++) {
                int minTouchTarget = minTouch[target.charAt(j) - 'A'];
                if (minTouchTarget == 200) {
                    canMake = false;
                    break;
                }
                sum += minTouchTarget;
            }
            answer[i] = canMake ? sum : -1;
        }
        return answer;
    }

    public int[] solution4(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();

        for (String key : keymap) {
            for (int j = 0; j < key.length(); j++) {

                char ch = key.charAt(j);

                if (map.containsKey(ch)) {
                    if (map.get(ch) > j) {
                        map.replace(ch, j + 1);
                    }
                } else {
                    map.put(ch, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {

                char ch = targets[i].charAt(j);

                if (map.containsKey(ch)) {
                    sum += map.get(ch);
                } else {
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }

        return answer;
    }

}
