package com.example.officialgsmclientserver.global.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
public class ErrorResponse {

    private final String formatNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd / HH : mm : ss "));
    private final String detailMessage;

    public static ResponseEntity<ErrorResponse> toResponseEntity(String detailMessage, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .body(ErrorResponse.builder()
                        .detailMessage(detailMessage)
                        .build()
                );
    }

}
