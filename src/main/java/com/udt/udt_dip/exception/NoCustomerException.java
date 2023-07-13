package com.udt.udt_dip.exception;

public class NoCustomerException extends RuntimeException {

    public NoCustomerException() {
        super();
    }

    public NoCustomerException(String message) {
        super(message);
    }

    public NoCustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCustomerException(Throwable cause) {
        super(cause);
    }

    protected NoCustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
