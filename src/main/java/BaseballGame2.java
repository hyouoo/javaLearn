import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame2 {
    public static void main(String[] args) {
        //computer 는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑는다.
        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2, num3;
        while (true) {
            num2 = random.nextInt(10);
            num3 = random.nextInt(10);
            if (num1 == num2 || num2 == num3 || num3 == num1) {
                continue;
            }
            break;
        }
        ArrayList<Integer> outNum = new ArrayList<>();
        outNum.add(num1);
        outNum.add(num2);
        outNum.add(num3);

        //게임이 종료될 때까지 사용자의 입력을 받는다
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        Scanner sc = new Scanner(System.in);
        int trialNum = 1;
        String result;
        while (true) {
            String trialStr = String.format("%d번째 시도 : ", trialNum);
            System.out.print(trialStr);
            int input = sc.nextInt();
            ArrayList<Integer> trial = new ArrayList<>();
            trial.add(input / 100);
            trial.add((input / 10) % 10);
            trial.add(input % 10);

            //두 개의 숫자를 비교하고 결과를 출력한다, 3개가 맞으면 게임을 종료한다
            int strike = 0;
            int ball = 0;
            for (int c : trial) {
                if (outNum.contains(c)) {
                    if (trial.indexOf(c) == outNum.indexOf(c)) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
            // 비교 결과에 따른 출력 양식을 선택
            if (strike == 0) {
                if (ball == 0) {
                    result = String.format("%dB%S", ball, strike);
                } else {
                    result = String.format("%dB", ball);
                }
            } else if (ball == 0) {
                result = String.format("%dS", strike);
            } else {
                result = String.format("%dB%dS", ball, strike);
            }
            System.out.println(result);
            // 게임 종료
            if (strike == 3) {
                String endResult = String.format("%d번만에 맞히셨습니다.", trialNum);
                System.out.println(endResult);
                System.out.println("게임을 종료합니다.");
                break;
            }
            trialNum++;
        }
    }
}
