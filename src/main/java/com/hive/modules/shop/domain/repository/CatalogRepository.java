package com.hive.modules.shop.domain.repository;

import com.hive.modules.shop.domain.model.Catalog;

import java.util.List;

public interface CatalogRepository {
    List<String> findByShopId(String shopId);
    int countByShopId(String shopId);
    boolean nameExistByShopId(String shopId, String name);
    void save(Catalog catalog);
}
