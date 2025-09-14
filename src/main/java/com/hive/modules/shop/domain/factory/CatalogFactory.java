package com.hive.modules.shop.domain.factory;

import com.hive.modules.shop.domain.model.Catalog;

public interface CatalogFactory {
    Catalog create(String shopId, String name);
}
