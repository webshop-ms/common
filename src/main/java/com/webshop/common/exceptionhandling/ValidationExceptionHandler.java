package com.webshop.common.exceptionhandling;

import com.webshop.common.model.exception.ValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Date;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<ValidationResponse> handleValidationException(ConstraintViolationException constraintViolationException, HttpServletRequest request) {
        ValidationResponse validationResponse = new ValidationResponse(
            new Date(),
            400,
            "Bad request",
            "ConstraintViolationException",
            request.getServletPath(),
            constraintViolationException.getConstraintViolations()
        );
        return new ResponseEntity<>(validationResponse, HttpStatus.BAD_REQUEST);
    }
}
