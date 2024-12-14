package com.example.crud_project.advices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.crud_project.exceptions.UserNotFoundException;
import com.example.crud_project.advices.ErrorItem;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response<?>> handleUserNotFoundException(UserNotFoundException ex) {
        var response = new ResponseBuilder<Response<?>>()
                .error(new ResponseError("U00", ex.getMessage())).setCode(404).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        var errors = new ArrayList<ErrorItem>();

        for (FieldError error : result.getFieldErrors())
            errors.add(new ErrorItem(error.getField(), error.getDefaultMessage()));

        var response = new ResponseBuilder<Response<?>>()
                .error(new ResponseError("U01", "Validation Error")).setCode(400).addFieldErrors(errors).build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<APIResponse<String>> handleGenericException(Exception
    // ex) {
    // APIResponse<String> response = new APIResponse<String>(false,
    // ex.getMessage(), null);
    // return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
}