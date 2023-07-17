package com.udt.udt_dip.common.exception;

public class NoContractException extends RuntimeException {

    public NoContractException() {
        super();
    }

    public NoContractException(String message) {
        super(message);
    }

    public NoContractException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoContractException(Throwable cause) {
        super(cause);
    }

    protected NoContractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
