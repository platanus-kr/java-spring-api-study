package com.project.springapistudy.beverages.commons.exceptionhandler;

import com.project.springapistudy.beverages.exception.BeverageNotFountException;
import com.project.springapistudy.beverages.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = Controller.class)
public class CustomExceptionController {

    @ExceptionHandler(BeverageNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse exception(BeverageNotFountException e) {
        return e.getResponse();
    }
}
