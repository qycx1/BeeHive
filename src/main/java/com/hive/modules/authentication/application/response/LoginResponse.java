package com.hive.modules.authentication.application.response;

import com.hive.modules.authentication.domain.result.UserProfileResult;

public record  LoginResponse (boolean success, UserProfileResult result, String error) {

    public static LoginResponse ok(UserProfileResult result) {
        return new LoginResponse(true, result, null);
    }

    public static LoginResponse fail(String error) {
        return new LoginResponse(false, null, error);
    }
}
