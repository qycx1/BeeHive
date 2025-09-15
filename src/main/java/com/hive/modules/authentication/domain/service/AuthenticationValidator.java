package com.hive.modules.authentication.domain.service;

import com.hive.modules.authentication.domain.repository.AuthRepository;
import com.hive.modules.authentication.domain.result.AuthValidatorResult;

public final class AuthenticationValidator {

    private final AuthRepository repository;

    public static final int MIN_USERNAME_LENGTH = 4;
    public static final int MAX_USERNAME_LENGTH = 30;
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 100;

    public AuthenticationValidator(AuthRepository repository) {
        this.repository = repository;
    }

    public AuthValidatorResult validate(String userId, String username, String password) {
        if (userId == null || userId.isBlank()) {
            return AuthValidatorResult.INVALID_USER_ID;
        }
        if (username == null || username.isBlank()) {
            return AuthValidatorResult.INVALID_USERNAME;
        }
        if (password == null || password.isBlank()) {
            return AuthValidatorResult.INVALID_PASSWORD;
        }

        if (repository.findByUserId(userId).isPresent()) {
            return AuthValidatorResult.USER_ID_ALREADY_EXISTS;
        }

        if (username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
            return AuthValidatorResult.INVALID_USERNAME_LENGTH;
        }

        if (repository.findByUsername(username).isPresent()) {
            return AuthValidatorResult.USERNAME_ALREADY_TAKEN;
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return AuthValidatorResult.INVALID_PASSWORD_LENGTH;
        }

        return AuthValidatorResult.SUCCESS;
    }
}
