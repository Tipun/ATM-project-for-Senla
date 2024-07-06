package com.ATM.service.java.com.ATM.exceptions;

public class MissingMenuItemException extends Exception {
    public MissingMenuItemException() {
        super();
    }

    public MissingMenuItemException(String message) {
        super(message);
    }

    public MissingMenuItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingMenuItemException(Throwable cause) {
        super(cause);
    }

    protected MissingMenuItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
