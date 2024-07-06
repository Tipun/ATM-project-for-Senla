package com.ATM.exceptions;

public class AccountBlockException extends Exception {
    public AccountBlockException() {
        super();
    }

    public AccountBlockException(String message) {
        super(message);
    }

    public AccountBlockException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountBlockException(Throwable cause) {
        super(cause);
    }

    protected AccountBlockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
