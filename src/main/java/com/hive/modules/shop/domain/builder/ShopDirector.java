package com.hive.modules.shop.domain.builder;

import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.model.Status;
import com.hive.shared.id.IDGenerator;

public class ShopDirector {

    private final ShopBuilder builder;
    private final IDGenerator idGenerator;

    public ShopDirector(ShopBuilder builder, IDGenerator idGenerator) {
        this.builder = builder;
        this.idGenerator = idGenerator;
    }

    private Shop baseShop(String userId, String name, String description, boolean isVerified) {
        return builder
                .shopId(idGenerator.generate())
                .userId(userId)
                .name(name)
                .status(Status.ACTIVE)
                .description(description)
                .isVerified(isVerified)
                .build();
    }

    public Shop buildDefaultShop(String userId, String name, String description) {
        return baseShop(userId, name, description, false);
    }

    public Shop buildVerifiedShop(String userId, String name, String description) {
        return baseShop(userId, name, description, true);
    }
}
