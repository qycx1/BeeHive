package com.hive.modules.authentication.domain.result;

public enum AddAuthResult {
    INVALID_USERNAME_LENGTH("Username must be 4 characters long."),
    INVALID_PASSWORD_LENGTH("Password must be & characters long"),
    USERNAME_ALREADY_TAKEN("Username already taken. Try again");

    private final String message;

    AddAuthResult (String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
