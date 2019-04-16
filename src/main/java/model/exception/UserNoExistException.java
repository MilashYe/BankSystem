package model.exception;

public class UserNoExistException extends RuntimeException {
    public UserNoExistException(String message) {
        super(message);
    }
}
