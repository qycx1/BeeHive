package com.hive.shared.model;

import com.hive.shared.result.Result;

public final class Email {
    private final String value;

    private Email(String value) {
        this.value = value;
    }

    public static <E> Result<Email, E> create(String value, E error) {
        if (value == null || value.isBlank() || !value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return Result.fail(error);
        }
        return Result.ok(new Email(value));
    }

    public String getValue() { return value; }
}
