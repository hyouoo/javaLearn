package AlgoChallange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 바탕화면 정리
// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// 입출력 예
//        wallpaper	                                    result
//        [".#...", "..#..", "...#."]	                [0, 1, 3, 4]
//        ["..........", ".....#....", "......##..", "...##.....", "....#....."]
//        	                                            [1, 3, 5, 8]
//        [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]
//        	                                            [0, 0, 7, 9]
//        ["..", "#."]	                                [1, 0, 2, 1]
public class Q60 {
    public static void main(String[] args) {
        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    // #의 인덱스를 조사해서 최소값과 최대값을 추출
    private static int[] solution(String[] wallpaper) {
        List<int[]> xPoint = new ArrayList<>();
        List<Integer> yPoint = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                yPoint.add(i);
                int[] temp = {wallpaper[i].indexOf("#"), wallpaper[i].lastIndexOf("#")};
                xPoint.add(temp);
            }
        }
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int[] ints : xPoint) {
            minX = Math.min(minX, ints[0]);
            maxX = Math.max(maxX, ints[1]);
        }
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int num : yPoint) {
            minY = Math.min(minY, num);
            maxY = Math.max(maxY, num);
        }
        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }

    public int[] solution2(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }
}
