package com.spark.membership.common;

import jakarta.validation.*;

import java.util.Set;

public abstract class SelfValidating<T>{
    private Validator validator;

    protected SelfValidating() {
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            this.validator = factory.getValidator();
        }
    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
