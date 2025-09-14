package com.hive.modules.shop.domain.repository;

import com.hive.modules.shop.domain.model.Shop;
import com.hive.modules.shop.domain.model.ShopStatistic;

import java.util.Optional;

public interface ShopRepository {
    Optional<Shop> findByUserId(String userId);
    boolean shopExistsByName(String name);
    boolean shopExistsById(String userId);
    void save(Shop shop, ShopStatistic statistics);
}
