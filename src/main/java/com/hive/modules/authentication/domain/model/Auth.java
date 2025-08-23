package com.hive.modules.authentication.domain.model;

import java.time.LocalDateTime;

public final class Auth {

    private final String userId;
    private final String authId;
    private String username;
    private String password;

    private Status status;
    private Roles role;

    private final LocalDateTime createdAt;

    public Auth(String authId,String userId, String username, String password, Status status, Roles role, LocalDateTime createdAt) {
        this.authId = authId;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
        this.createdAt = createdAt;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


}
