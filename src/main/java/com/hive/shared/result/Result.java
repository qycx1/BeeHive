package com.hive.shared.result;

public record Result<T>(
    boolean success,
    T data,
    String errorMessage
)
{

    public static <T> Result<T> ok(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> fail(String errorMessage) {
        return new Result<>(false, null, errorMessage);
    }


}
