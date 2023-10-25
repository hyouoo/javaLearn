package AlgoChallange;

// 둘만의 암호
// https://school.programmers.co.kr/learn/courses/30/lessons/155652
// 입출력 예
//      s	    skip	index	result
//      "aukks"	"wbqd"	5	    "happy"
public class Q57 {
    public static void main(String[] args) {
        String s = "z", skip = "a";
        int index = 1;
        System.out.println(solution(s, skip, index));
    }

    // abcdefghijklmnopqrstuvwxyz
    // s를 char[]로 만들어서 각 char에서 'a'를 빼고 index만큼 더하기
    // skip할 단어의 갯수를 파악해서 더하고 % 26해서 char를 반환
    // skip할 단어의 갯수는 어떻게 파악해야 되나?, z에서 index 이동하면 a부터 확인해야 함
    // skip으로 이동하는 동안 다시 skip할 단어를 만나면 추가 이동이 필요함!!
    private static String solution(String s, String skip, int index) {
        char[] result = new char[s.length()];
        int i = 0;
        for (char ch : s.toCharArray()) {
            int countSkip = 0, j = 0, idx = index;
            while (idx > 0) {
                j++;
                if (skip.indexOf(('a' + (ch - 'a' + j) % 26))!=-1) {
                    countSkip++;
                } else {
                    idx--;
                }
            }
            result[i++] = (char) ('a' + (ch - 'a' + index + countSkip) % 26);
        }
        return String.valueOf(result);
    }
    
    public String solution2(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }
        return answer.toString();
    }
    

    private static int skipCount(char ch, String skip, int index, int acc) {
        if (index == 0) return acc;
        int count = 0;
        for (char sk : skip.toCharArray()) {
            if (ch < sk && sk <= ch + index) count++;
        }
        acc += count;
        return skipCount((char) (ch + index), skip, count, acc);
    }
}
