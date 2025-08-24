package com.hive.modules.users.application.request;

import com.hive.modules.users.domain.model.Address;

import java.time.LocalDate;
import java.util.Set;

public record RegisterAccountRequest(String firstName, String lastName, String email,
                                     Set<Address> addresses, String phoneNumber, LocalDate birthday) {
}
