package com.hive.modules.users.domain.service;

import com.hive.modules.users.domain.factory.UserFactory;
import com.hive.modules.users.domain.model.Address;
import com.hive.modules.users.domain.model.Email;
import com.hive.modules.users.domain.model.PhoneNumber;
import com.hive.modules.users.domain.model.User;
import com.hive.modules.users.domain.repository.UserRepository;
import com.hive.shared.result.Result;

import java.time.LocalDate;
import java.util.Set;

public final class AddAccount {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public AddAccount(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public Result<User> add(String firstName, String lastName, String email,
                            Set<Address> addresses, String phoneNumber, LocalDate birthday) {

        Result<PhoneNumber> phoneResult = PhoneNumber.create(phoneNumber);
        if (!phoneResult.success()) {
            return Result.fail(phoneResult.errorMessage());
        }

        var emailResult = Email.create(email);
        if (!emailResult.success()) {
            return Result.fail(emailResult.errorMessage());
        }

        if (birthday.isAfter(LocalDate.now())) {
            return Result.fail("Birthday cannot be in the future");
        }

        if (birthday.isBefore(LocalDate.now().minusYears(150))) {
            return Result.fail("Birthday cannot be more than 150 years ago.");
        }

        User user = userFactory.create(
                firstName, lastName,
                emailResult.data().getValue(),
                addresses,
                phoneResult.data().getValue(),
                birthday
        );

        userRepository.save(user);
        return Result.ok(user);
    }

}
