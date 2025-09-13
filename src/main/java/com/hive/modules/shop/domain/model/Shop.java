package com.hive.modules.shop.domain.model;

import java.time.LocalDateTime;

public final class Shop {

    private final String shopId;
    private final String userId;
    private final LocalDateTime createdAt;

    private String name;
    private String description;
    private Status status;
    private boolean verified;
    private String profileImageUrl;

    public Shop(String shopId,String userId, String name,String description,Status status,boolean verified,String profileImageUrl,LocalDateTime createdAt) {
        this.shopId = shopId;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.verified = verified;
        this.profileImageUrl = profileImageUrl;
        this.createdAt = createdAt;
    }

    public String getShopId() {
        return shopId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
