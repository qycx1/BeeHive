package com.hive.modules.users.domain.repository;

import com.hive.modules.users.domain.model.User;

public interface UserRepository {
    void save(User user);
}
