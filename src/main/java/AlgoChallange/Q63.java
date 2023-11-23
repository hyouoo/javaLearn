package AlgoChallange;

import java.util.Arrays;

// 공원 산책
// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// 입출력 예
//        park	                    routes	            result
//        ["SOO","OOO","OOO"]	    ["E 2","S 2","W 1"]	[2,1]
//        ["SOO","OXX","OOO"]	    ["E 2","S 2","W 1"]	[0,1]
//        ["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
public class Q63 {
    public static void main(String[] args) {
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    private static int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        int[] size = {park[0].length(), park.length};

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                start[0] = i;
                start[1] = park[i].indexOf("S");
                break;
            }
        }

        int destination, distance;
        boolean passFlag;
        for (String route : routes) {
            String[] split = route.split(" ");
            distance = Integer.parseInt(split[1]);
            passFlag = false;
            switch (split[0]) {
                case "E":
                    destination = start[1] + distance;
                    if (destination >= size[1]) {
                        break;
                    }
                    for (int i = 1; i <= distance; i++) {
                        if (park[start[0]].charAt(start[1] + i) == 'X') {
                            passFlag = true;
                            break;
                        }
                    }
                    if (passFlag) break;
                    start[1] += distance;
                    break;
                case "W":
                    destination = start[1] - distance;
                    if (destination < 0) {
                        break;
                    }
                    for (int i = 1; i <= distance; i++) {
                        if (park[start[0]].charAt(start[1] - i) == 'X') {
                            passFlag = true;
                            break;
                        }
                    }
                    if (passFlag) break;
                    start[1] -= distance;
                    break;
                case "N":
                    destination = start[0] - distance;
                    if (destination < 0) {
                        break;
                    }
                    for (int i = 1; i <= distance; i++) {
                        if (park[start[0] - i].charAt(start[1]) == 'X') {
                            passFlag = true;
                            break;
                        }
                    }
                    if (passFlag) break;
                    start[0] -= distance;
                    break;
                case "S":
                    destination = start[0] + distance;
                    if (destination >= size[0]) {
                        break;
                    }
                    for (int i = 1; i <= distance; i++) {
                        if (park[start[0] + i].charAt(start[1]) == 'X') {
                            passFlag = true;
                            break;
                        }
                    }
                    if (passFlag) break;
                    start[0] += distance;
                    break;
            }
        }
        return start;
    }
}
