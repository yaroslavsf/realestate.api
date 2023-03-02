package ch.noseryoung.realestate.core.exception.exceptions;

import ch.noseryoung.realestate.core.exception.errors.ErrorCode;

public class CustomNoSuchElementException extends GeneralException{
    public CustomNoSuchElementException(ErrorCode errorCode, String developerMessage, Exception exception) {
        super(errorCode, developerMessage, exception);
    }
}
