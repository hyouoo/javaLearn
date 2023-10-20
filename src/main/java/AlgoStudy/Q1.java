package AlgoStudy;

import java.util.Scanner;
// 문제 설명
//      정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
// 제한 조건
//      num은 int 범위의 정수입니다.
//      0은 짝수입니다.
// 입출력 예
//      num	return
//      3	"Odd"
//      4	"Even"
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(Solution.solution(num));
    }
}
class Solution {
    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
