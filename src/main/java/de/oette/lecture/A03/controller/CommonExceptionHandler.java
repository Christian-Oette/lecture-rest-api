package de.oette.lecture.A03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleExceptions(Throwable ex) {
        return new ErrorDto(ex.getMessage());
    }
}
