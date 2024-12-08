package com.example.crud_project.advices;

public class APIResponse<T> {

    private boolean success;
    private T data;
    private String message;

    public APIResponse(boolean success, String message, T data) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}