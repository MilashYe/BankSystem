package model.exception;

public class UserToAccountException extends RuntimeException {
    public UserToAccountException(String message) {
        super(message);
    }
}
