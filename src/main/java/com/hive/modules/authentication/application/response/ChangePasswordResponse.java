package com.hive.modules.authentication.application.response;

public enum ChangePasswordResponse {
    INVALID_AUTH_ID_INPUT,
    INVALID_OLD_PASSWORD_INPUT,
    INVALID_NEW_PASSWORD_INPUT,
    INVALID_PASSWORD_LENGTH,
    AUTHID_NOTFOUND,
    WRONG_PASSWORD,
    SUCCESS;
}
