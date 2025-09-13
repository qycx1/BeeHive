package com.hive.modules.shop.domain.repository;

import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.model.ShopStatistic;

import java.util.Optional;

public interface ShopRepository {
    Optional<Shop> findByUserId(String shopId);
    boolean shopExistsByName(String name);
    boolean shopExistsById(String id);
    void save(Shop shop, ShopStatistic statistics);
}
