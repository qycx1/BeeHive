package com.hive.modules.authentication.application.service;

import com.hive.modules.authentication.application.request.ChangePasswordRequest;
import com.hive.modules.authentication.application.response.ChangePasswordResponse;
import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.repository.AuthRepository;
import com.hive.modules.authentication.util.BCryptHasher;

import java.util.Optional;

import static com.hive.modules.authentication.application.response.ChangePasswordResponse.*;

public final class AuthChangePassword {

    private final AuthRepository repository;

    public AuthChangePassword (AuthRepository repository) {
        this.repository = repository;
    }

    public ChangePasswordResponse execute(ChangePasswordRequest request) {
        if(request.authId() == null || request.authId().isEmpty()) {
            return INVALID_AUTH_ID_INPUT;
        }

        if(request.oldPassword() == null || request.oldPassword().isEmpty()) {
            return INVALID_OLD_PASSWORD_INPUT;
        }

        if(request.newPassword() == null || request.newPassword().isEmpty()) {
            return INVALID_NEW_PASSWORD_INPUT;
        }

        if(request.newPassword().length() < 8) {
            return INVALID_PASSWORD_LENGTH;
        }

        Optional<Auth> authOpt = repository.findById(request.authId());

        if(authOpt.isEmpty()) {
            return AUTHID_NOTFOUND;
        }

        Auth auth = authOpt.get();

        if(!BCryptHasher.verify(request.oldPassword(), auth.getPassword())) {
            return WRONG_PASSWORD;
        }

        auth.changePassword(request.oldPassword(), request.newPassword());
        repository.update(auth);
        return SUCCESS;
    }


}
