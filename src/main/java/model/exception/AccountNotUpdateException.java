package model.exception;

public class AccountNotUpdateException extends RuntimeException {
    public AccountNotUpdateException(String message) {
        super(message);
    }
}
