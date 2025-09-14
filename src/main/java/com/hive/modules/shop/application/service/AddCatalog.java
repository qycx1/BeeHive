package com.hive.modules.shop.application.service;

import com.hive.modules.shop.application.request.AddCatalogRequest;
import com.hive.modules.shop.application.response.AddCatalogResponse;
import com.hive.modules.shop.domain.factory.CatalogFactory;
import com.hive.modules.shop.domain.model.Catalog;
import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.repository.CatalogRepository;
import com.hive.modules.shop.domain.result.CatalogRulesRecord;
import com.hive.modules.shop.domain.result.CatalogRulesResult;
import com.hive.modules.shop.domain.service.CatalogRules;


public class AddCatalog {


    private final CatalogRules catalogRules;
    private final CatalogRepository catalogRepository;
    private final CatalogFactory factory;

    public AddCatalog(CatalogRules catalogRules,CatalogRepository catalogRepository,CatalogFactory factory) {
        this.catalogRules = catalogRules;
        this.catalogRepository = catalogRepository;
        this.factory = factory;
    }

    public AddCatalogResponse execute(AddCatalogRequest request) {

        CatalogRulesRecord check = catalogRules.check(request.userId(), request.catalogName());
        if (check.result() != CatalogRulesResult.SUCCESS) {
            return AddCatalogResponse.fail(check.result());
        }

        Shop shop = check.shop();

        Catalog catalog = factory.create(shop.getShopId(), request.catalogName());

        catalogRepository.save(catalog);

        return AddCatalogResponse.success(check.result().getMessage());
    }

}
