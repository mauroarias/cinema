package com.example.cinema.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handlerBadParametersException(final NotFoundException ex) {
        return buildAndLog(ErrorType.NOT_FOUND, NOT_FOUND, ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception ex) {
        return buildAndLog(ErrorType.UNKNOWN_ERROR, INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity buildAndLog(final ErrorType errorType, final HttpStatus httpStatus, final Exception ex) {
        log.error("exception caught, exception {}, StackTrace {}", ex.getMessage(), ExceptionUtils.getStackTrace(ex));
        return new ResponseEntity<>(Error.builder()
                                         .errorType(errorType)
                                         .exceptionType(ex.getClass().getCanonicalName())
                                         .message(ex.getMessage())
                                         .build(),
                                    httpStatus);
    }
}
