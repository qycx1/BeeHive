package com.hive.modules.users.domain.model;

import com.hive.shared.result.Result;

public final class Email {
    private final String value;

    private Email(String value) {
        this.value = value;
    }

    public static Result<Email> create(String value) {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return Result.fail("Invalid email format");
        }
        return Result.ok(new Email(value));
    }

    public String getValue() { return value; }
}
