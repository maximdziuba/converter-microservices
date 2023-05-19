package com.example.currencyservice.controller;

import com.example.currencyservice.exception.CurrencyNotFoundException;
import com.example.currencyservice.exception.ExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CurrencyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handlerCurrencyNotFoundException(CurrencyNotFoundException e) {
        return new ExceptionBody(e.getMessage());
    }
}
