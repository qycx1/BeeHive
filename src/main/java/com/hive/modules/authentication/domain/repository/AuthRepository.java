package com.hive.modules.authentication.domain.repository;

import com.hive.modules.authentication.domain.model.Auth;

import java.util.Optional;

public interface AuthRepository {

    Optional<Auth> findById(String authId);
    Optional<Auth> findByUsername(String username);
    Optional<Auth> findByEmail(String email);
    Optional<Auth> findByUserId(String userId);
    void update(Auth auth);
    void save(Auth auth);
    void delete(Auth auth);
}
