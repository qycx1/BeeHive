package com.hive.modules.users.application.response;

import com.hive.modules.users.domain.model.User;

import java.util.Optional;

public enum ChangeRoleResult {
    USERID_NULL,
    ROLE_NULL,
    USER_ID_NOT_FOUND,
    CHANGE_ROLE_SUCCESS;
}
