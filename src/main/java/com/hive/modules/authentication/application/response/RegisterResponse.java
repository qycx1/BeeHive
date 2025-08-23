package com.hive.modules.authentication.application.response;

public record RegisterResponse (boolean success, String message) {


    public static RegisterResponse ok(String message) {
        return new RegisterResponse(true,message);
    }

    public static RegisterResponse fail(String message) {
        return new RegisterResponse(false,message);
    }
}
