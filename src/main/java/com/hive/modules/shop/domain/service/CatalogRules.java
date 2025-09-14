package com.hive.modules.shop.domain.service;

import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.repository.CatalogRepository;
import com.hive.modules.shop.domain.repository.ShopRepository;
import com.hive.modules.shop.domain.result.CatalogRulesRecord;
import com.hive.modules.shop.domain.result.CatalogRulesResult;

public class CatalogRules {

    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_CATALOGS_PER_SHOP = 20;

    private final ShopRepository shopRepository;
    private final CatalogRepository catalogRepository;

    public CatalogRules(ShopRepository shopRepository, CatalogRepository catalogRepository) {
        this.shopRepository = shopRepository;
        this.catalogRepository = catalogRepository;
    }

    public CatalogRulesRecord check(String userId, String catalogName) {
        if (userId == null || userId.isBlank()) return CatalogRulesRecord.fail(CatalogRulesResult.SHOP_NOT_FOUND);
        if (catalogName == null || catalogName.isBlank()) return CatalogRulesRecord.fail(CatalogRulesResult.EMPTY_NAME);
        if (catalogName.length() > MAX_NAME_LENGTH) return CatalogRulesRecord.fail(CatalogRulesResult.NAME_TOO_LONG);

        var shopOpt = shopRepository.findByUserId(userId);
        if (shopOpt.isEmpty()) return CatalogRulesRecord.fail(CatalogRulesResult.SHOP_NOT_FOUND);

        Shop shop = shopOpt.get();

        if (catalogRepository.countByShopId(shop.getShopId()) >= MAX_CATALOGS_PER_SHOP) {
            return CatalogRulesRecord.fail(CatalogRulesResult.MAX_CATALOGS_REACHED);
        }

        if(catalogRepository.nameExistByShopId(shop.getShopId(),catalogName)){
            return CatalogRulesRecord.fail(CatalogRulesResult.NAME_ALREADY_EXISTS);
        }

        return CatalogRulesRecord.ok(shop);
    }
}
