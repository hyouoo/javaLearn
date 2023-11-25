package codekata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// JadenCase 문자열 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12951
// 입출력 예
//        s	                        return
//        "3people unFollowed me"	"3people Unfollowed Me"
//        "for the last week"	    "For The Last Week"
public class Q76 {
    public static void main(String[] args) {
        String s = "3people  unFollowed me";
        System.out.println(solution2(s));
    }

    private static String solution(String s) {
        String[] split = s.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() == 1) {
                sb.append(Character.toUpperCase(split[i].charAt(0)));
            } else {
                sb.append(Character.toUpperCase(split[i].charAt(0))).append(split[i], 1, split[i].length());
            }
            if (i < split.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String solution2(String s) {
        String sLowerCase = s.toLowerCase();
        Pattern pattern = Pattern.compile("\\s\\S");
        Matcher matcher = pattern.matcher(sLowerCase);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group().toUpperCase());
        }
        matcher.appendTail(sb);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }


}
