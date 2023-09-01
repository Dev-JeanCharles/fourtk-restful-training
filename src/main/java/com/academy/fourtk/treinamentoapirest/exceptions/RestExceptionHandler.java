package com.academy.fourtk.treinamentoapirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException r, HttpServletRequest h) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setPath(h.getRequestURI());
        error.setMessage(r.getMessage());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validationBadlyFormatted(MethodArgumentNotValidException r, HttpServletRequest h) {

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError();

        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Validation Exception");
        error.setPath(h.getRequestURI());
        error.setMessage(r.getMessage());

        for (FieldError f : r.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(),f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }

}
