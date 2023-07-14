package com.udt.udt_dip.exception;

public class NoMobilePlanException extends RuntimeException {

    public NoMobilePlanException() {
        super();
    }

    public NoMobilePlanException(String message) {
        super(message);
    }

    public NoMobilePlanException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMobilePlanException(Throwable cause) {
        super(cause);
    }

    protected NoMobilePlanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
