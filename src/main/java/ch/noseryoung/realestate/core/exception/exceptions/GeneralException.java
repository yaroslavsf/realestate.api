package ch.noseryoung.realestate.core.exception.exceptions;

import ch.noseryoung.realestate.core.exception.errors.ErrorCode;

public class GeneralException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String developerMessage;
    private final Exception exception;

    public GeneralException(ErrorCode errorCode, String developerMessage, Exception exception) {
        super(developerMessage);
        this.errorCode = errorCode;
        this.developerMessage = developerMessage;
        this.exception = exception;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Exception getException() {
        return exception;
    }
}

