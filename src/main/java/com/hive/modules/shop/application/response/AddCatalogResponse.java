package com.hive.modules.shop.application.response;

import com.hive.modules.shop.domain.result.CatalogRulesResult;

public record AddCatalogResponse(boolean success, String message, CatalogRulesResult error) {

    public static AddCatalogResponse success(String message) {
        return new AddCatalogResponse(true, message, null);
    }

    public static AddCatalogResponse fail(CatalogRulesResult error) {
        return new AddCatalogResponse(false, error.name(), error);
    }
}
