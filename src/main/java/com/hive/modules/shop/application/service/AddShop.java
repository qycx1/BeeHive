package com.hive.modules.shop.application.service;

import com.hive.modules.shop.application.request.AddShopRequest;
import com.hive.modules.shop.application.response.AddShopError;
import com.hive.modules.shop.application.response.AddShopResponse;
import com.hive.modules.shop.domain.builder.ShopDirector;
import com.hive.modules.shop.domain.builder.ShopStatisticBuilder;
import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.model.ShopStatistic;
import com.hive.modules.shop.domain.repository.ShopRepository;
import com.hive.modules.shop.domain.result.ShopRuleResult;
import com.hive.modules.shop.domain.service.ShopRule;

public final class AddShop {

    private final ShopRule shopRule;
    private final ShopDirector director;
    private final ShopRepository repository;

    public AddShop(ShopRule shopRule, ShopDirector director, ShopRepository repository) {
        this.shopRule = shopRule;
        this.director = director;
        this.repository = repository;
    }

    public AddShopResponse createShop(AddShopRequest request) {
        String userId = request.userId();
        String name = request.name();
        String description = request.description();

        if (userId == null || userId.isBlank()) {
            return AddShopResponse.fail(AddShopError.MISSING_USER_ID);
        }

        if (name == null || name.isBlank()) {
            return AddShopResponse.fail(AddShopError.MISSING_SHOP_NAME);
        }

        if (description == null || description.isBlank()) {
            return AddShopResponse.fail(AddShopError.MISSING_DESCRIPTION);
        }

        ShopRuleResult ruleResult = shopRule.check(userId, name);
        if (ruleResult != ShopRuleResult.SUCCESS) {
            return AddShopResponse.fail(AddShopError.SHOP_NAME_ALREADY_EXISTS);
        }

        Shop shop = director.buildDefaultShop(userId, name, description);

        ShopStatistic statistic = new ShopStatisticBuilder()
                .shopId(shop.getShopId())
                .rating(0.0)
                .totalSales(0)
                .followerCount(0)
                .followingCount(0)
                .productCount(0)
                .totalReviews(0)
                .build();

        repository.save(shop, statistic);

        return AddShopResponse.success("Shop created successfully: " + shop.getShopId());
    }
}
