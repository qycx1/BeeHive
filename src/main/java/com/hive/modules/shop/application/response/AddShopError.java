package com.hive.modules.shop.application.response;

public enum AddShopError {
    MISSING_USER_ID("User ID is required"),
    MISSING_SHOP_NAME("Shop name is required"),
    MISSING_DESCRIPTION("Description is required"),
    SHOP_NAME_ALREADY_EXISTS("Shop name already exists for this user"),
    USER_ALREADY_HAS_SHOP("User already owns a shop"),
    UNKNOWN_ERROR("An unknown error occurred");

    private final String defaultMessage;

    AddShopError(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getMessage() {
        return defaultMessage;
    }
}
