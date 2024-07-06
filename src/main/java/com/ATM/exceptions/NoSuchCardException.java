package com.ATM.exceptions;

public class NoSuchCardException extends Exception {
    public NoSuchCardException() {
        super();
    }

    public NoSuchCardException(String message) {
        super(message);
    }

    public NoSuchCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCardException(Throwable cause) {
        super(cause);
    }

    protected NoSuchCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
