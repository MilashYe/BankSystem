package model.exception;

public class NotEnoughtMoneyException extends RuntimeException {
    public NotEnoughtMoneyException(String message) {
        super(message);
    }
}
