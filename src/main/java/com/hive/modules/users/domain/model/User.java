package com.hive.modules.users.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class User {

    private final String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Address> addresses;
    private String phoneNumber;
    private LocalDate birthday;

    private LocalDateTime lastLogin;

    public User(String userId, String firstName, String lastName, String email, Set<Address> addresses, String phoneNumber, LocalDate birthday) {
    this.userId = userId;
    this.firstName =firstName;
    this.lastName = lastName;
    this.email =email;
    this.addresses = addresses;
    this.phoneNumber = phoneNumber;
    this.birthday = birthday;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }



}
