package com.luciuswong.renting.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldValueMatchValidator implements ConstraintValidator<FieldValueMatch, Object> {
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
