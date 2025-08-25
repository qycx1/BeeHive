package com.hive.shared.model;

import com.hive.modules.users.domain.result.AddAccountResult;
import com.hive.shared.result.Result;

public final class PhoneNumber {
    private final String value;

    private PhoneNumber(String value) {
        this.value = value;
    }

    public static <P> Result<PhoneNumber, P> create(String raw, P error) {
        if (raw == null || !raw.matches("\\d+")) {
            return Result.fail(error);
        }
        return Result.ok(new PhoneNumber(raw));
    }

    public String getValue() {
        return value;
    }
}
