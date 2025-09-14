package com.hive.modules.shop.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Catalog {
    private final String catalogId;
    private final String shopId;
    private String name;
    private final List<String> productIds;

    public Catalog(String catalogId, String shopId, String name, List<String> productIds) {
        this.catalogId = catalogId;
        this.shopId = shopId;
        this.name = name;
        this.productIds = new ArrayList<>(productIds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public List<String> getProductIds() {
        return Collections.unmodifiableList(productIds);
    }

    public String getShopId() {
        return shopId;
    }

    public String getType() {
        return name;
    }

    public void addProduct(String productId) {
        if (!productIds.contains(productId)) {
            productIds.add(productId);
        }
    }

    public void removeProduct(String productId) {
        productIds.remove(productId);
    }
}