package com.hive.modules.users.domain.service;

import com.hive.modules.users.domain.factory.UserFactory;
import com.hive.modules.users.domain.model.*;
import com.hive.modules.users.domain.repository.UserRepository;
import com.hive.modules.users.domain.result.AddAccountResult;
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

    public Result<User, AddAccountResult> add(String firstName, String lastName, String email,
                                              Set<Address> addresses, String phoneNumber, LocalDate birthday) {

        Result<PhoneNumber, AddAccountResult> phoneResult = PhoneNumber.create(phoneNumber);
        if (!phoneResult.success()) {
            return Result.fail(phoneResult.errorMessage());
        }

        Result<Email, AddAccountResult> emailResult = Email.create(email);
        if (!emailResult.success()) {
            return Result.fail(emailResult.errorMessage());
        }

        Result<Birthday, AddAccountResult> birthdayResult = Birthday.create(birthday);

        if(!birthdayResult.success()) {
            return Result.fail(birthdayResult.errorMessage());
        }

        User user = userFactory.create(
                firstName, lastName,
                emailResult.data().getValue(),
                addresses,
                phoneResult.data().getValue(),
                birthdayResult.data().getValue()
        );

        userRepository.save(user);
        return Result.ok(user);
    }

}
