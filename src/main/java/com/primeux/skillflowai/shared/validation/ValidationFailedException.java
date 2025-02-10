package com.primeux.skillflowai.shared.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.util.HashSet;
import java.util.Set;

public class ValidationFailedException extends ConstraintViolationException {

    public ValidationFailedException(String message) {
        super(message, new HashSet<>());
    }

    public ValidationFailedException(String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(message, constraintViolations);
    }

    public ValidationFailedException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(constraintViolations);
    }

}
