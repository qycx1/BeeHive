package com.hive.modules.authentication.application.service;

import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.service.AddAuthentication;
import com.hive.modules.authentication.application.request.RegisterRequest;
import com.hive.modules.authentication.application.response.RegisterResponse;
import com.hive.shared.result.Result;

public final class UserAuthenticationRegistrar {

    private final AddAuthentication addAuthentication;

    public UserAuthenticationRegistrar(AddAuthentication addAuthentication) {
        this.addAuthentication = addAuthentication;
    }

    public RegisterResponse register(RegisterRequest request) {

        if (request.userId() == null || request.userId().isBlank()) {
            return RegisterResponse.fail("Invalid UserID input.");
        }
        if (request.username() == null || request.username().isBlank()) {
            return RegisterResponse.fail("Invalid username input.");
        }
        if (request.password() == null || request.password().isBlank()) {
            return RegisterResponse.fail("Invalid password input.");
        }

        Result<Auth> result = addAuthentication.add(request.userId(), request.username(), request.password());

        if (!result.success()) {
            return RegisterResponse.fail(result.errorMessage());
        }

        return RegisterResponse.ok(  "Successfully added authentication for " + request.userId());
    }
}
