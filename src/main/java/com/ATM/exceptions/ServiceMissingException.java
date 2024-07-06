package com.ATM.exceptions;

public class ServiceMissingException extends Exception {
    public ServiceMissingException() {
        super();
    }

    public ServiceMissingException(String message) {
        super(message);
    }

    public ServiceMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceMissingException(Throwable cause) {
        super(cause);
    }

    protected ServiceMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
