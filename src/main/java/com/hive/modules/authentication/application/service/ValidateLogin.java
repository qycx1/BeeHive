package com.hive.modules.authentication.application.service;

import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.repository.AuthRepository;
import com.hive.modules.authentication.domain.result.LoginResult;
import com.hive.modules.authentication.util.BCryptHasher;
import com.hive.shared.model.Email;
import com.hive.shared.result.Result;

import java.util.Optional;

public final class ValidateLogin {

    private final AuthRepository repository;

    public ValidateLogin(AuthRepository repository) {
        this.repository = repository;
    }

    public LoginResult validateByUsername(String username, String password) {
        Optional<Auth> authOpt = repository.findByUsername(username);

        if (authOpt.isEmpty()) {
            return LoginResult.USERNAME_NOT_FOUND;
        }

        Auth auth = authOpt.get();
        if (!BCryptHasher.verify(password, auth.getPassword())) {
            return LoginResult.WRONG_PASSWORD;
        }

        return LoginResult.SUCCESS;
    }

    public LoginResult validateByEmail(String email, String password) {
        Result<Email, LoginResult> emailResult = Email.create(email, LoginResult.INVALID_EMAIL);
        if (!emailResult.success()) return emailResult.errorMessage();

        Optional<Auth> authOpt = repository.findByEmail(emailResult.data().getValue());

        if (authOpt.isEmpty()) {
            return LoginResult.EMAIL_NOT_FOUND;
        }

        Auth auth = authOpt.get();
        if (!BCryptHasher.verify(password, auth.getPassword())) {
            return LoginResult.WRONG_PASSWORD;
        }

        return LoginResult.SUCCESS;
    }

}
