package com.hive.modules.authentication.domain.model;

import com.hive.modules.authentication.domain.exception.PasswordMismatchException;
import com.hive.modules.authentication.util.BCryptHasher;

import java.time.LocalDateTime;

public final class Auth {

    private final String userId;
    private final String authId;
    private String username;
    private String password;

    private Status status;

    private final LocalDateTime createdAt;

    public Auth(String authId,String userId, String username, String password, Status status, LocalDateTime createdAt) {
        this.authId = authId;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getAuthId() {
        return authId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if(!BCryptHasher.verify(oldPassword, password)){
            throw new PasswordMismatchException("Old password does not match.");
        }
        if(newPassword.length() < 8){
            throw new IllegalArgumentException("Password must be at least 8 characters.");
        }
        this.password = BCryptHasher.hash(newPassword);
    }
}
