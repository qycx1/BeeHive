package com.hive.modules.authentication.domain.factory;

import com.hive.modules.authentication.domain.model.Auth;

public interface AuthFactory {
    Auth create(String userId,String username, String password);
}
