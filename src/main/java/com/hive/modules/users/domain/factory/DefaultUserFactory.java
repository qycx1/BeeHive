package com.hive.modules.users.domain.factory;

import com.hive.modules.users.domain.model.Address;
import com.hive.modules.users.domain.model.User;
import com.hive.shared.id.IDGenerator;

import java.time.LocalDate;
import java.util.Set;

public class DefaultUserFactory implements UserFactory{

    private final IDGenerator idGenerator;

    public DefaultUserFactory(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public User create(String firstName, String lastName, String email, Set<Address> addresses, String phoneNumber, LocalDate birthday) {
        return new User(idGenerator.generate(), firstName ,lastName, email, addresses, phoneNumber, birthday);
    }
}
