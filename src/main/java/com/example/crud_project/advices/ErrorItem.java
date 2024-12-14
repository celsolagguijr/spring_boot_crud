package com.example.crud_project.advices;

public class ErrorItem {
    private String field;
    private String message;

    ErrorItem(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
