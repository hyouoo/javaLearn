package WeekFourHW;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public void parseFirstNum(String firstInput) throws BadInputException {
        // 구현 1.
        if (!firstInput.matches(NUMBER_REG)) {
            throw new BadInputException("정수");
        }
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
    }

    public void parseSecondNum(String secondInput) throws BadInputException {
        // 구현 1.
        if (!secondInput.matches(NUMBER_REG)) {
            throw new BadInputException("정수");
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
    }

    public void parseOperator(String operationInput) throws BadInputException {
        // 구현 1.
        if (!operationInput.matches(OPERATION_REG)) {
            throw new BadInputException("연산자");
        }
        switch (operationInput) {
            case "+" -> this.calculator.setOperation(new AddOperation());
            case "-" -> this.calculator.setOperation(new SubtractOperation());
            case "*" -> this.calculator.setOperation(new MultiplyOperation());
            case "/" -> this.calculator.setOperation(new DivideOperation());
        }
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}
