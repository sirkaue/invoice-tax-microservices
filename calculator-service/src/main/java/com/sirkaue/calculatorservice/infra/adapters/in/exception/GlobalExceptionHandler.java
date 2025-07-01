package com.sirkaue.calculatorservice.infra.adapters.in.exception;

import com.sirkaue.calculatorservice.infra.adapters.in.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleStrategyNotSet(IllegalStateException ex, HttpServletRequest request) {
        return createErrorResponse(request, HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpServletRequest request) {
        Exception formatted = new Exception("Invalid enum value or malformed JSON.");
        return createErrorResponse(request, HttpStatus.BAD_REQUEST, formatted);
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(
            HttpServletRequest request,
            HttpStatus status,
            Exception exception) {
        ErrorResponse error = new ErrorResponse(request, status, exception);
        return ResponseEntity.status(status).contentType(APPLICATION_JSON).body(error);
    }
}
