package com.example.crud_project.advices;

public class ResponseError {
    private String code;
    private String message;
    private String description;

    public ResponseError(String code, String message) {
        this.code = code;
        this.message = message;
        this.description = message;
    }

    public ResponseError(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}