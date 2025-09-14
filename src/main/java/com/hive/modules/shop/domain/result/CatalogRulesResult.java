package com.hive.modules.shop.domain.result;

public enum CatalogRulesResult {
    SUCCESS("Catalog can be created successfully."),
    EMPTY_NAME("Catalog name cannot be empty."),
    NAME_TOO_LONG("Catalog name exceeds the maximum allowed length."),
    NAME_ALREADY_EXISTS("A catalog with this name already exists in the shop."),
    SHOP_NOT_FOUND("Shop not found for the given user."),
    MAX_CATALOGS_REACHED("Maximum number of catalogs for this shop has been reached.");

    private final String message;

    CatalogRulesResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
