package com.hive.modules.authentication.domain.repository;

import com.hive.modules.authentication.domain.model.Auth;

import java.util.Optional;

public interface AuthRepository {

    Optional<Auth> findById(String userId);
    Optional<Auth> findByUsername(String username);
    Optional<Auth> findByEmail(String email);
    void save(Auth auth);
    void delete(Auth auth);
}
