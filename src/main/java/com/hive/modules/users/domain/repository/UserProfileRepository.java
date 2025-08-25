package com.hive.modules.users.domain.repository;

import com.hive.modules.authentication.domain.result.UserProfileResult;

import java.util.Optional;

public interface UserProfileRepository {
    Optional<UserProfileResult> getProfileByUsername(String username);
    Optional<UserProfileResult> getProfileByEmail(String email);
}
