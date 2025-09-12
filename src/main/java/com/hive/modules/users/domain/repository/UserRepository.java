package com.hive.modules.users.domain.repository;

import com.hive.modules.users.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserId(String userId);
    void save(User user);
    void update(User user);
}
