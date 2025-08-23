package com.hive.modules.users.domain.model;

import com.hive.modules.users.domain.result.AddAccountResult;
import com.hive.shared.result.Result;

public final class Email {
    private final String value;

    private Email(String value) {
        this.value = value;
    }

    public static Result<Email, AddAccountResult> create(String value) {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return Result.fail(AddAccountResult.INVALID_EMAIL);
        }


        return Result.ok(new Email(value));
    }

    public String getValue() { return value; }
}
