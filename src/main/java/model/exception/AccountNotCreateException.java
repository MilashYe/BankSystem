package model.exception;

public class AccountNotCreateException extends RuntimeException {
    public AccountNotCreateException(String mess) {
        super(mess);
    }
}
