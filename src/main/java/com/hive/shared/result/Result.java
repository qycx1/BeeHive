package com.hive.shared.result;

public record Result<T,E>(boolean success, T data, E errorMessage)
{

    public static <T,E> Result<T,E> ok(T data) {
        return new Result<>(true, data, null);
    }


    public static <T,E> Result<T,E> fail(E errorMessage) {
        return new Result<>(false, null, errorMessage);
    }


}
