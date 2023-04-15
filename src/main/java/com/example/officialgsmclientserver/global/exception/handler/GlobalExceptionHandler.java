package com.example.officialgsmclientserver.global.exception.handler;

import com.example.officialgsmclientserver.global.exception.CustomException;
import com.example.officialgsmclientserver.global.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ErrorResponse.toResponseEntity(e.getDetailMessage(), e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(Exception e) {
        return ErrorResponse.toResponseEntity("예외 처리되지 않은 에러가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
