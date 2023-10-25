package AlgoChallange;

// 햄버거 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/133502
// 입출력 예
//      ingredient	                                result
//      [2, 1, 1, 2, 3, 1, 2, 3, 1]	                2
//      [1, 3, 2, 1, 2, 1, 3, 1, 2]	                0
//      [1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1]  3
public class Q58 {
    public static void main(String[] args) {
        int[] ingredient = {1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
//        System.out.println(solution(ingredient));
        System.out.println(solution2(ingredient));
    }

    // int[]를 String으로 바꿔서 replace 1231을 ""으로 변환, 반복하면서 count++ continue사용, else break;
    // replaceFirst는 시간 초과 발생, replaceAll은 추가된 테스트케이스에서 오답 (순서대로 빼야 됨)
    // sb를 만들면서 검색하고 빼야 됨, Stack 사용하는 방법도 있음
    private static int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        for (int num : ingredient) {
            sb.append(num);
        }
        String str = sb.toString();
        int lenOriginal = str.length();
        while (true) {
            if (str.contains("1231")) {
                str = str.replaceFirst("1231", "");
            } else {
                break;
            }
        }
        int lenAfter = str.length();
        return (lenOriginal - lenAfter) / 4;
    }

    private static int solution2(int[] ingredient) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int num : ingredient) {
            sb.append(num);
            if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                count++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }
        return count;
    }

}
