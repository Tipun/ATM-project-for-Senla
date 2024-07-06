package com.ATM.exceptions;

public class NotSufficientBalanceException extends Exception {
    public NotSufficientBalanceException() {
        super();
    }

    public NotSufficientBalanceException(String message) {
        super(message);
    }

    public NotSufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSufficientBalanceException(Throwable cause) {
        super(cause);
    }

    protected NotSufficientBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
