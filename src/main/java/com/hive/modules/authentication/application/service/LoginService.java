package com.hive.modules.authentication.application.service;

import com.hive.modules.authentication.application.request.LoginRequest;
import com.hive.modules.authentication.application.response.LoginResponse;
import com.hive.modules.authentication.domain.result.LoginResult;
import com.hive.modules.authentication.application.response.UserProfileResult;
import com.hive.modules.users.domain.repository.UserProfileRepository;

public final class LoginService {

    private final UserProfileRepository profileRepository;
    private final ValidateLogin validateLogin;

    public LoginService (UserProfileRepository profileRepository, ValidateLogin validateLogin) {
        this.profileRepository = profileRepository;
        this.validateLogin = validateLogin;
    }

    public LoginResponse loginWithUsername(LoginRequest request) {
        if(request.field() == null || request.field().isBlank()) {
            return LoginResponse.fail("Invalid username input.");
        }

        if(request.password() == null || request.password().isBlank()) {
            return LoginResponse.fail("Invalid password input.");
        }

        LoginResult result = validateLogin.validateByUsername(request.field(), request.password());

        switch(result) {
            case USERNAME_NOT_FOUND ->  LoginResponse.fail("Username not found.");
            case INVALID_EMAIL -> LoginResponse.fail("Invalid email.");
            case WRONG_PASSWORD -> LoginResponse.fail("Wrong password.");
            case SUCCESS -> {
                UserProfileResult profile = profileRepository.getProfileByUsername(request.field()).orElseThrow(() -> new IllegalArgumentException("Username not found."));
                return LoginResponse.ok(profile);
            }
        }
        throw new IllegalArgumentException("Unexpected error has occurred. (Login)");
    }

    public LoginResponse loginWithEmail(LoginRequest request) {
        if(request.field() == null || request.field().isBlank()) {
            return LoginResponse.fail("Invalid username input.");
        }

        if(request.password() == null || request.password().isBlank()) {
            return LoginResponse.fail("Invalid password input.");
        }

        LoginResult result = validateLogin.validateByEmail(request.field(), request.password());

        switch(result) {
            case EMAIL_NOT_FOUND -> LoginResponse.fail("Email not found.");
            case INVALID_EMAIL -> LoginResponse.fail("Invalid email.");
            case WRONG_PASSWORD -> LoginResponse.fail("Wrong password.");
            case SUCCESS -> {
                UserProfileResult profile = profileRepository.getProfileByEmail(request.field()).orElseThrow(()
                                                        -> new IllegalArgumentException("Username not found."));
                return LoginResponse.ok(profile);
            }
        }
        throw new IllegalArgumentException("Unexpected error has occurred. (Login)");
    }

}
