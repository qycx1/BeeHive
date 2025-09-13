package com.hive.modules.shop.domain.builder;

import com.hive.modules.shop.domain.model.ShopStatistic;

public class ShopStatisticBuilder {

    private String shopId;
    private double rating = 0.0;
    private int totalSales = 0;
    private int totalReviews = 0;
    private int followerCount = 0;
    private int followingCount = 0;
    private int productCount = 0;

    public ShopStatisticBuilder shopId(String shopId) {
        this.shopId = shopId;
        return this;
    }

    public ShopStatisticBuilder rating(double rating) {
        this.rating = rating;
        return this;
    }

    public ShopStatisticBuilder totalSales(int totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    public ShopStatisticBuilder totalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
        return this;
    }

    public ShopStatisticBuilder followerCount(int followerCount) {
        this.followerCount = followerCount;
        return this;
    }

    public ShopStatisticBuilder followingCount(int followingCount) {
        this.followingCount = followingCount;
        return this;
    }

    public ShopStatisticBuilder productCount(int productCount) {
        this.productCount = productCount;
        return this;
    }


    public ShopStatistic build() {
        return new ShopStatistic(
                shopId,
                rating,
                totalSales,
                followerCount,
                followingCount,
                productCount,
                totalReviews
        );
    }


}
