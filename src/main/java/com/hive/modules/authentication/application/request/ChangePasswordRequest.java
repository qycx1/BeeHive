package com.hive.modules.authentication.application.request;

public record ChangePasswordRequest(String authId, String oldPassword, String newPassword) {
}
