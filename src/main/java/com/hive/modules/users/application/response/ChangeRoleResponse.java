package com.hive.modules.users.application.response;

import com.hive.modules.users.domain.model.Roles;

import java.util.Optional;

public record ChangeRoleResponse(ChangeRoleResult result , Optional<Roles> newRole) {
    public static ChangeRoleResponse fail(ChangeRoleResult result) {
        return new ChangeRoleResponse(result, Optional.empty());
    }

    public static ChangeRoleResponse ok(Roles newRole) {
        return new ChangeRoleResponse(ChangeRoleResult.CHANGE_ROLE_SUCCESS, Optional.ofNullable(newRole));
    }
}
