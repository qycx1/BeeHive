package com.hive.modules.shop.domain.result;

import com.hive.modules.shop.domain.model.Shop;

public record CatalogRulesRecord(CatalogRulesResult result, Shop shop) {

    public static CatalogRulesRecord ok(Shop shop) {
        return new CatalogRulesRecord(CatalogRulesResult.SUCCESS, shop);
    }

    public static CatalogRulesRecord fail(CatalogRulesResult error) {
        return new CatalogRulesRecord(error, null);
    }
}
