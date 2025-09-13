package com.hive.modules.shop.domain.model;

public class ShopStatistic {

    private final String shopId;
    private double rating;
    private long totalSales;
    private int followerCount;
    private int followingCount;
    private int productCount;
    private int totalReviews;

    public ShopStatistic(String shopId,double rating,int totalSales,int followerCount,int followingCount,int productCount,int totalReviews) {
        this.shopId = shopId;
        this.rating = rating;
        this.totalSales = totalSales;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.productCount = productCount;
        this.totalReviews = totalReviews;
    }

    public String getShopId() {
        return shopId;
    }

    public double getRating() {
        return rating;
    }

    public long getTotalSales() {
        return totalSales;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void incrementFollower() {
        followerCount++;
    }

    public void decrementFollower() {
        if (followerCount > 0) followerCount--;
    }

    public void incrementFollowing() {
        followingCount++;
    }

    public void decrementFollowing() {
        if (followingCount > 0) followingCount--;
    }

    public void incrementProductCount() {
        productCount++;
    }

    public void decrementProductCount() {
        if (productCount > 0) productCount--;
    }

    public void addSale(long count) {
        if (count > 0) totalSales += count;
    }

    public void addReview(int stars) {
        double totalStars = rating * totalReviews;
        totalReviews++;
        rating = (totalStars + stars) / totalReviews;
    }
}
