package com.hive.modules.authentication.application.service;

import com.hive.modules.authentication.application.request.RegisterRequest;
import com.hive.modules.authentication.application.response.RegisterResponse;
import com.hive.modules.authentication.domain.factory.AuthFactory;
import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.repository.AuthRepository;
import com.hive.modules.authentication.domain.result.AuthValidatorResult;
import com.hive.modules.authentication.domain.service.AuthenticationValidator;
import com.hive.modules.authentication.util.BCryptHasher;

public final class UserAuthenticationRegistrar {

    private final AuthenticationValidator validator;
    private final AuthRepository repository;
    private final AuthFactory factory;

    public UserAuthenticationRegistrar(AuthenticationValidator validator,
                                       AuthRepository repository,
                                       AuthFactory factory) {
        this.validator = validator;
        this.repository = repository;
        this.factory = factory;
    }

    public RegisterResponse register(RegisterRequest request) {
        AuthValidatorResult result = validator.validate(
                request.userId(), request.username(), request.password());

        if (result != AuthValidatorResult.SUCCESS) {
            return RegisterResponse.fail(buildMessage(result));
        }

        Auth auth = factory.create(
                request.userId(),
                request.username(),
                BCryptHasher.hash(request.password())
        );
        repository.save(auth);

        return RegisterResponse.ok("Successfully registered user " + request.userId());
    }

    private String buildMessage(AuthValidatorResult result) {
        return switch (result) {
            case INVALID_USERNAME_LENGTH -> String.format(
                    "Username must be between %d and %d characters long.",
                    AuthenticationValidator.MIN_USERNAME_LENGTH,
                    AuthenticationValidator.MAX_USERNAME_LENGTH
            );
            case INVALID_PASSWORD_LENGTH -> String.format(
                    "Password must be between %d and %d characters long.",
                    AuthenticationValidator.MIN_PASSWORD_LENGTH,
                    AuthenticationValidator.MAX_PASSWORD_LENGTH
            );
            case USERNAME_ALREADY_TAKEN -> "Username already taken. Try again.";
            case INVALID_PASSWORD -> "Invalid password input.";
            case USER_ID_ALREADY_EXISTS -> "User ID already exists.";
            case INVALID_USERNAME -> "Invalid username input.";
            case INVALID_USER_ID -> "Invalid user ID input.";
            case SUCCESS -> "Registration successful.";
        };
    }
}
