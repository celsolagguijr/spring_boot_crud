package com.example.crud_project.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankImp implements ConstraintValidator<NotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println(value);

        if (value == null)
            return false;

        if (value == "")
            return false;

        if (value.trim().length() <= 0)
            return false;

        return true;

    }

}