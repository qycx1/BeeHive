package com.hive.modules.users.application.request;

import com.hive.modules.users.domain.model.Roles;

public record ChangeRoleRequest(String userid, Roles roles) {
}
