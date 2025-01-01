package com.example.kbhc.framework.dto;

public record ResponseInfo<T>(
        int status,
        String message,
        T data
) {
}
