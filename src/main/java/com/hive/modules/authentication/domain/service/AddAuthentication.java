package com.hive.modules.authentication.domain.service;

import com.hive.modules.authentication.domain.factory.AuthFactory;
import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.repository.AuthRepository;
import com.hive.modules.authentication.domain.result.AddAuthResult;
import com.hive.modules.authentication.util.BCryptHasher;
import com.hive.shared.result.Result;


public final class AddAuthentication {

    private final AuthFactory factory;
    private final AuthRepository repository;

    public AddAuthentication(AuthFactory factory, AuthRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public Result<Auth, AddAuthResult> add(String userId, String username, String password) {

        if(username.length() < 4) {
            return Result.fail(AddAuthResult.INVALID_USERNAME_LENGTH);
        }

        if(password.length() < 8) {
            return Result.fail(AddAuthResult.INVALID_PASSWORD_LENGTH);
        }

        if(repository.findByUsername(username).isPresent()) {
            return Result.fail(AddAuthResult.USERNAME_ALREADY_TAKEN);
        }

        String hashed = BCryptHasher.hash(password);

        Auth authentication = factory.create(userId, username, hashed);
        repository.save(authentication);

        return Result.ok(authentication);
    }
}

