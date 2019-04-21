package model.exception;

public class WrongDestinationAccountException extends RuntimeException {
    public WrongDestinationAccountException(String message) {
        super(message);
    }
}
