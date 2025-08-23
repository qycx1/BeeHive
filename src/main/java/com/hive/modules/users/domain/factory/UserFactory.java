package com.hive.modules.users.domain.factory;

import com.hive.modules.users.domain.model.Address;
import com.hive.modules.users.domain.model.User;

import java.time.LocalDate;
import java.util.Set;

public interface UserFactory {

    User create(String firstName, String lastName, String email, Set<Address> addresses, String phoneNumber, LocalDate birthday);
}
