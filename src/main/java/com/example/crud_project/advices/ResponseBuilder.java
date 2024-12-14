package com.example.crud_project.advices;

public class ResponseBuilder<T> {

    private final Response<T> response = new Response<>();

    public ResponseBuilder<T> setCode(int code) {
        response.setCode(code);
        return this;
    }

    public ResponseBuilder<T> setData(T data) {
        response.setData(data);
        return this;
    }

    public ResponseBuilder<T> success() {
        response.setSuccess(true);
        response.setCode(200);
        return this;
    }

    public ResponseBuilder<T> error(ResponseError error) {
        response.setError(error);
        response.setSuccess(false);
        response.setCode(500);
        return this;
    }

    public Response<T> build() {
        return response;
    }

}
