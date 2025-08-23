package com.hive.modules.users.domain.model;

import com.hive.modules.users.domain.result.AddAccountResult;
import com.hive.shared.result.Result;

import java.time.LocalDate;

public class Birthday {

    private final LocalDate value;

    private Birthday(LocalDate value) {
        this.value = value;
    }

    public static Result<Birthday, AddAccountResult> create(LocalDate value) {
        if(value == null
                || value.isBefore(LocalDate.now().minusYears(150))) {
            return Result.fail(AddAccountResult.AGE_TOO_HIGH);
        }

        if(
           value.isAfter(LocalDate.now())) {
            return Result.fail(AddAccountResult.BIRTHDAY_IN_FUTURE);
        }

        return Result.ok(new Birthday(value));
    }

    public LocalDate getValue() {
        return value;
    }
}
