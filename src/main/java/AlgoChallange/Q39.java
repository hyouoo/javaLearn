package AlgoChallange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 두 개 뽑아서 더하기
// 문제 설명
//        정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
//        배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
// 제한사항
//        numbers의 길이는 2 이상 100 이하입니다.
//        numbers의 모든 수는 0 이상 100 이하입니다.
// 입출력 예
//        numbers	    result
//        [2,1,3,4,1]	[2,3,4,5,6,7]
//        [5,0,2,7]	    [2,5,7,9,12]
public class Q39 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    private static int[] solution(int[] numbers) {
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }
        int[] result = new int[sumSet.size()];
        int i = 0;
        for (Integer n: sumSet) {
            result[i] = n;
            i++;
        }
        Arrays.sort(result); // TreeSet 사용시 sort 필요 없음
        return result;
    }
}
