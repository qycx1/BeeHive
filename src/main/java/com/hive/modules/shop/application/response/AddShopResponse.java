package com.hive.modules.shop.application.response;

public record AddShopResponse(boolean success, String message, AddShopError error) {

    public static AddShopResponse fail(AddShopError error) {
        return new AddShopResponse(false, error.getMessage(), error);
    }

    public static AddShopResponse success(String message) {
        return new AddShopResponse(true, message, null);
    }
}
