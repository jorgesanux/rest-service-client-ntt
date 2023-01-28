package com.ex.client.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Response {
    private int statucCode;
    private String message;
}
