package com.hive.modules.users.domain.model;

import com.hive.modules.users.domain.result.AddAccountResult;
import com.hive.shared.result.Result;

public final class PhoneNumber {
    private final String value;

    private PhoneNumber(String value) {
        this.value = value;
    }

    public static Result<PhoneNumber, AddAccountResult> create(String raw) {
        if (raw == null || !raw.matches("\\d+")) {
            return Result.fail(AddAccountResult.INVALID_PHONE);
        }
        return Result.ok(new PhoneNumber(raw));
    }

    public String getValue() {
        return value;
    }
}
