package com.example.crud_project.advices;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private boolean success;
    private int code;
    private ResponseError error;
    private T data;

    public void setCode(int code) {
        this.code =code;
    }

    public int getCode(){
        return this.code;
    }

    public T getData() {
        return data;
    }
    public ResponseError getError() {
        return error;
    }
    public void setError(ResponseError error) {
        this.error = error;
    }

    public void setFieldErrors(List<ErrorItem> fieldErrors) {
        this.error.setFieldErrors(fieldErrors);
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public void setData(T data) {
        this.data = data;
    }
}