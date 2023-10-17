package WeekThreeHW;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator(new AddOperation());
        System.out.println(cal.calculate(3, 5));
        cal.setOperation(new SubtractOperation());
        System.out.println(cal.calculate(3, 5));
    }
}
