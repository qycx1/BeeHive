package com.hive.modules.authentication.domain.service;

import com.hive.modules.authentication.domain.factory.AuthFactory;
import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.repository.AuthRepository;
import com.hive.modules.authentication.util.BCryptHasher;
import com.hive.shared.result.Result;


public final class AddAuthentication {

    private final AuthFactory factory;
    private final AuthRepository repository;

    public AddAuthentication(AuthFactory factory, AuthRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public Result<Auth> add(String userId, String username, String password) {

        if(username.length() < 4) {
            return Result.fail("Username must not be less than 4 characters.");
        }

        if(password.length() < 8) {
            return Result.fail("Password must be more than 8 characters long.");
        }

        if(repository.findByUsername(username).isPresent()) {
            return Result.fail("Username already taken.");
        }

        String hashed = BCryptHasher.hash(password);

        Auth authentication = factory.create(userId, username, hashed);
        repository.save(authentication);

        return Result.ok(authentication);
    }
}

