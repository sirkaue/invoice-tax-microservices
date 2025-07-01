package com.sirkaue.invoiceservice.infra.adapters.in.controller;

import com.sirkaue.invoiceservice.infra.adapters.in.dto.ErrorResponse;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(HttpServletRequest request) {

        var error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase(),
                "External service temporally unavailable",
                request.getRequestURI(),
                request.getMethod()
        );

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).contentType(APPLICATION_JSON).body(error);
    }
}
