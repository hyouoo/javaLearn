package AlgoMarathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 모의고사
// 문제 설명
//        수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
// 제한 조건
//        시험은 최대 10,000 문제로 구성되어있습니다.
//        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
// 입출력 예
//        answers	    return
//        [1,2,3,4,5]	[1]
//        [1,3,2,4,2]	[1,2,3]
public class Q47 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answers)));
    }

    private static int[] solution(int[] answers) {
        // 3명의 답안을 생성, answers크기로 초기화
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] stu1 = new int[answers.length];
        int[] stu2 = new int[answers.length];
        int[] stu3 = new int[answers.length];
        for (int i = 0; i < answers.length; i++) {
            stu1[i] = pattern1[i % pattern1.length];
            stu2[i] = pattern2[i % pattern2.length];
            stu3[i] = pattern3[i % pattern3.length];
        }
        int[] score = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == stu1[i]) score[0]++;
            if (answers[i] == stu2[i]) score[1]++;
            if (answers[i] == stu3[i]) score[2]++;
        }
        int maxScore = score[0];
        for (int i = 1; i < score.length; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                result.add(i + 1);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int[] solution2(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[patterns.length];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
