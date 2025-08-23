package com.hive.modules.authentication.domain.factory;

import com.hive.modules.authentication.domain.model.Auth;
import com.hive.modules.authentication.domain.model.Roles;
import com.hive.modules.authentication.domain.model.Status;
import com.hive.shared.id.IDGenerator;

import java.time.LocalDateTime;

public final class DefaultAuthFactory implements AuthFactory{


    private final IDGenerator idGenerator;

    public DefaultAuthFactory(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Auth create(String userId,String username, String password) {
        return new Auth(idGenerator.generate(), userId,username,password,Status.ACTIVE, Roles.BUYER, LocalDateTime.now());
    }

}
