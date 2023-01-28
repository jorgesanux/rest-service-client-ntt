package com.ex.client.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiError extends Response {
    private String error;

    public ApiError(HttpStatus httpStatus, String message) {
        super(httpStatus.value(), message);
        this.error = httpStatus.getReasonPhrase();
    }
}
