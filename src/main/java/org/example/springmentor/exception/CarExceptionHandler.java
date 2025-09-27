package org.example.springmentor.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.springmentor.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CarExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handlerException(CarNotFoundException carNotFoundException) {
        log.error("Car not found exception: {}", carNotFoundException.getMessage());
        return new ExceptionDto("Car Not Found");
    }
}
