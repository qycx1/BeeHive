package com.hive.modules.users.application.response;

import com.hive.modules.users.domain.model.User;

import java.util.Optional;

public enum ChangeRoleResult {
    USERID_NULL("Invalid User ID"),
    ROLE_NULL("Invalid Role"),
    USER_ID_NOT_FOUND("User ID is not found."),
    CHANGE_ROLE_SUCCESS("Successfully changed role");

    private final String message;

    ChangeRoleResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
