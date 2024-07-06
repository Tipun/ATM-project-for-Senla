package com.ATM.service.java.com.ATM.exceptions;

public class NotEnoughMoneyInBankomatException extends Exception {
    public NotEnoughMoneyInBankomatException() {
        super();
    }

    public NotEnoughMoneyInBankomatException(String message) {
        super(message);
    }

    public NotEnoughMoneyInBankomatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughMoneyInBankomatException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughMoneyInBankomatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
