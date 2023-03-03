package ch.noseryoung.realestate.core.exception;

import ch.noseryoung.realestate.core.exception.exceptions.CustomNoSuchElementException;
import ch.noseryoung.realestate.core.exception.exceptions.GeneralException;
import ch.noseryoung.realestate.core.exception.exposederrors.ApiError;
import ch.noseryoung.realestate.core.exception.exposederrors.MyError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {
    //May be used for further ExceptionHandlers
    //messageSource.getMessage("errors.exception.message", null, LocaleContextHolder.getLocale())
    private MessageSource messageSource;

    @Autowired
    public CustomGlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CustomNoSuchElementException.class)
    public ResponseEntity<ApiError> handleMethodNoSuchElementException(CustomNoSuchElementException ex, HttpServletRequest request) {
        return getApiErrorResponseEntity(ex, request, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiError> getApiErrorResponseEntity(GeneralException exception, HttpServletRequest request, HttpStatus status) {
        return new ResponseEntity<> (
                new ApiError()
                        .setPath(request.getRequestURL().toString())
                        .setError(new MyError(exception.getErrorCode().getErrorCode(), exception.getErrorCode().getLocalizationKey()))
                        .setTimeStamp(LocalDate.now()),
                status
        );
    }
}
