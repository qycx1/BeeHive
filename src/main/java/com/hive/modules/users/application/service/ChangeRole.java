package com.hive.modules.users.application.service;

import com.hive.modules.users.application.request.ChangeRoleRequest;
import com.hive.modules.users.application.response.ChangeRoleResponse;
import com.hive.modules.users.application.response.ChangeRoleResult;
import com.hive.modules.users.domain.model.User;
import com.hive.modules.users.domain.repository.UserRepository;

import java.util.Optional;

public final class ChangeRole {

    private final UserRepository repository;

    public ChangeRole(UserRepository repository) {
        this.repository = repository;
    }

    public ChangeRoleResponse execute(ChangeRoleRequest request) {
     if(request == null || request.userid().isEmpty()) {
        return ChangeRoleResponse.fail(ChangeRoleResult.USERID_NULL);
     }

     if(request.roles() == null) {
         return ChangeRoleResponse.fail(ChangeRoleResult.ROLE_NULL);
     }

     Optional<User> userOpt = repository.findByUserId(request.userid());

    if(userOpt.isEmpty()){
        return ChangeRoleResponse.fail(ChangeRoleResult.USER_ID_NOT_FOUND);
    }

    User user = userOpt.get();

    user.setRole(request.roles());
    repository.update(user);
    return ChangeRoleResponse.ok(request.roles());
    }


}
