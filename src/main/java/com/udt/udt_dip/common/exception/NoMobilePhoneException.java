package com.udt.udt_dip.common.exception;

public class NoMobilePhoneException extends RuntimeException {
    public NoMobilePhoneException() {
        super();
    }

    public NoMobilePhoneException(String message) {
        super(message);
    }

    public NoMobilePhoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMobilePhoneException(Throwable cause) {
        super(cause);
    }

    protected NoMobilePhoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
