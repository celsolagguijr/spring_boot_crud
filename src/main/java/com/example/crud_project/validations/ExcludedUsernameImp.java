package com.example.crud_project.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExcludedUsernameImp implements ConstraintValidator<ExcludedUsername, String> {

    String[] excludedUsernames;

    @Override
    public void initialize(ExcludedUsername constraint) {
        this.excludedUsernames = constraint.excludedUsernames();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        for (String username : excludedUsernames) {
            if (username.equals(value))
                return false;
        }

        return true;
    }

}