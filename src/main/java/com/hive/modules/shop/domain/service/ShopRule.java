package com.hive.modules.shop.domain.service;

import com.hive.modules.shop.domain.repository.ShopRepository;
import com.hive.modules.shop.domain.result.ShopRuleResult;


public final class ShopRule {

    private final ShopRepository repository;

    public ShopRule(ShopRepository repository) {
        this.repository = repository;
    }

    public ShopRuleResult check(String userId, String name) {
        if(repository.shopExistsById(userId)) return ShopRuleResult.OWNER_HAS_SHOP;
        if(repository.shopExistsByName(name)) return ShopRuleResult.SHOP_NAME_EXIST;
        return ShopRuleResult.SUCCESS;
    }

}
