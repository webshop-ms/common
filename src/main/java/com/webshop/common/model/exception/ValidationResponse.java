package com.webshop.common.model.exception;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationResponse extends FallbackResponse {

    @Getter
    private List<ValidationParamDetail> invalidParams;

    public ValidationResponse(Date timestamp, int status, String error, String message, String path, Set<ConstraintViolation<?>> constraintViolationSet) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.invalidParams = convertConstraintViolationToDetailedList(constraintViolationSet);
    }

    private List<ValidationParamDetail> convertConstraintViolationToDetailedList(Set<ConstraintViolation<?>> constraintViolationSet) {
        return constraintViolationSet
            .stream()
            .map(c -> new ValidationParamDetail(c.getPropertyPath().toString(), c.getInvalidValue().toString(), c.getMessage()))
            .collect(Collectors.toList());
    }
}
