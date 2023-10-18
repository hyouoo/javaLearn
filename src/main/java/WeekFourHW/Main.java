package WeekFourHW;

public class Main {
    public static void main(String[] args) {
        boolean calculateEnded = false;
        // 구현 2.
        while (!calculateEnded) {
            try {
                calculateEnded = CalculatorApp.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (calculateEnded) {
                    System.out.println("계산이 종료되었습니다.");
                }
            }
        }
    }
}
