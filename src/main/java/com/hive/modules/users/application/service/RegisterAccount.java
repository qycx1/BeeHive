package com.hive.modules.users.application.service;

import com.hive.modules.users.application.request.RegisterAccountRequest;
import com.hive.modules.users.application.response.RegisterAccountResponse;
import com.hive.modules.users.domain.model.User;
import com.hive.modules.users.domain.repository.UserRepository;
import com.hive.modules.users.domain.result.AddAccountResult;
import com.hive.modules.users.domain.service.AddAccount;
import com.hive.shared.result.Result;

public final class RegisterAccount {

    private final UserRepository repository;
    private final AddAccount addAccount;

    public RegisterAccount(UserRepository repository, AddAccount addAccount) {
        this.repository = repository;
        this.addAccount = addAccount;
    }

    public RegisterAccountResponse register(RegisterAccountRequest request) {

        if (request.firstName() == null || request.firstName().isBlank()) {
            return new RegisterAccountResponse(false, "First name cannot be empty");
        }
        if (request.lastName() == null || request.lastName().isBlank()) {
            return new RegisterAccountResponse(false, "Last name cannot be empty");
        }
        if (request.email() == null || request.email().isBlank()) {
            return new RegisterAccountResponse(false, "Email cannot be empty");
        }
        if (request.phoneNumber() == null || request.phoneNumber().isBlank()) {
            return new RegisterAccountResponse(false, "Phone number cannot be empty");
        }
        if (request.addresses() == null || request.addresses().isEmpty()) {
            return new RegisterAccountResponse(false, "At least one address is required");
        }
        if (request.birthday() == null) {
            return new RegisterAccountResponse(false, "Birthday cannot be null");
        }

        Result<User, AddAccountResult> result = addAccount.add(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.addresses(),
                request.phoneNumber(),
                request.birthday()
        );

        if (!result.success()) {
            String errors = result.errorMessage() != null ? result.errorMessage().getMessage() : "Unknown error";
            return new RegisterAccountResponse(false, errors);
        }

        User user = result.data();
        repository.save(user);

        return new RegisterAccountResponse(
                true,
                "User registered successfully"
        );
    }
}
