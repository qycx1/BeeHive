package com.hive.modules.shop.domain.model;

import java.time.LocalDateTime;

public final class Shop {
    private final String shopId;
    private final String userId;
    private String name;
    private String description;
    private Status status;
    private double rating;
    private boolean isVerified;
    private long totalSales;
    private int followerCount;
    private int followingCount;
    private int productCount;
    private int totalReviews;

    private final LocalDateTime createdAt;

    public Shop(LocalDateTime createdAt, String shopId, String userId, String description, int followerCount,
                int followingCount, boolean isVerified, String name, int productCount, double rating,
                Status status, long totalSales, int totalReviews) {

        this.createdAt = createdAt;
        this.shopId = shopId;
        this.userId = userId;
        this.description = description;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.isVerified = isVerified;
        this.name = name;
        this.productCount = productCount;
        this.rating = rating;
        this.status = status;
        this.totalSales = totalSales;
        this.totalReviews = totalReviews;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void addFollowerCount() {
        this.followerCount++;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void addFollowingCount() {
        this.followingCount++;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCount() {
        return productCount;
    }

    public void addProductCount() {
        this.productCount++;
    }

    public double getRating() {
        return rating;
    }

    public void addRating(double newRating) {
        if (newRating < 0 || newRating > 5)
            throw new IllegalArgumentException("Rating must be between 0 and 5");

        this.rating = ((this.rating * totalReviews) + newRating) / (totalReviews + 1);
        totalReviews++;
    }

    public String getShopId() {
        return shopId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(long totalSales) {
        this.totalSales = totalSales;
    }

    public String getUserId() {
        return userId;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void addTotalReview() {
        this.totalReviews++;
    }
}
