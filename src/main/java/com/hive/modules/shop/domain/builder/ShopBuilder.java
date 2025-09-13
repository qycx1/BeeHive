package com.hive.modules.shop.domain.builder;

import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.model.Status;

import java.time.LocalDateTime;

public class ShopBuilder {

    private String shopId;
    private String userId;
    private String name;
    private String description;
    private Status status;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private String profileImageURL;

    public ShopBuilder() {
        this.createdAt = LocalDateTime.now();
        this.status = Status.ACTIVE;
        this.isVerified = false;
    }

    public ShopBuilder shopId(String shopId) {
        this.shopId = shopId;
        return this;
    }

    public ShopBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public ShopBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ShopBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ShopBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public ShopBuilder isVerified(boolean isVerified) {
        this.isVerified = isVerified;
        return this;
    }

    public ShopBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ShopBuilder profileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
        return this;
    }

    public Shop build() {
        return new Shop(
                shopId,
                userId,
                name,
                description,
                status,
                isVerified,
                profileImageURL,
                createdAt
        );
    }
}
