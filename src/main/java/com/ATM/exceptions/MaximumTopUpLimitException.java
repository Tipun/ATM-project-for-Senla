package com.ATM.exceptions;

public class MaximumTopUpLimitException extends Exception {
    public MaximumTopUpLimitException() {
        super();
    }

    public MaximumTopUpLimitException(String message) {
        super(message);
    }

    public MaximumTopUpLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaximumTopUpLimitException(Throwable cause) {
        super(cause);
    }

    protected MaximumTopUpLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
