package com.ex.client.util;

import lombok.Getter;

@Getter
public class ApiResponse<T> extends Response {
    private T result;

    public ApiResponse(int statucCode, String message, T result) {
        super(statucCode, message);
        this.result = result;
    }
}
