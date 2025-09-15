package com.hive.modules.authentication.domain.result;

public enum AuthValidatorResult {
    SUCCESS,
    INVALID_USER_ID,
    INVALID_USERNAME,
    INVALID_PASSWORD,
    USER_ID_ALREADY_EXISTS,
    INVALID_USERNAME_LENGTH,
    INVALID_PASSWORD_LENGTH,
    USERNAME_ALREADY_TAKEN
}
