package com.tenantbridge.api.common.handler;

import com.tenantbridge.api.common.mappers.ObjectNotValidException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<?> handleException(ObjectNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getErrorMessages());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
