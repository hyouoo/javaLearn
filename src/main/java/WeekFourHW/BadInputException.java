package WeekFourHW;

public class BadInputException extends Exception {
    public BadInputException(String type) {
        super("잘못된 입력입니다! " + type + "를(을) 입력해주세요!");
    }
}
