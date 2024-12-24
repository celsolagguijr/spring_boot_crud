package com.example.crud_project.validations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// FIELD, CLASS OR METHOD
@Target(ElementType.FIELD)
// RUNTIME, SOURCE OR CLASS
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankImp.class)
public @interface NotBlank {

    String message() default "Field can't be blank or empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
