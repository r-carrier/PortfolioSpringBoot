package com.rcarrier.personalwebsite.portfolio.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemNotFoundAdvice {

    // render advice straight into the response body
    @ResponseBody
    // configure advice to only respond if an ItemNotFoundException is thrown
    @ExceptionHandler(ItemNotFoundException.class)
    // issues an HttpStatus.NOT_FOUND, i.e. an HTTP 404
    @ResponseStatus
    String itemNotFoundHandler(ItemNotFoundException ex) {
        return ex.getMessage();
    }
}
