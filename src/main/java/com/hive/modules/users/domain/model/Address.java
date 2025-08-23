package com.hive.modules.users.domain.model;

public class Address {
    private final String addressId;
    private final String userId;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    private boolean isDefault;

    public Address (String addressId, String userId, String street, String city, String state, String postalCode, String country, boolean isDefault) {
        this.addressId = addressId;
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.isDefault = isDefault;
    }

    public String getUserId() {
        return userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressId() {
        return addressId;
    }
}
