package com.hive.modules.users.domain.model;

import java.util.Collections;
import java.util.Set;

import static com.hive.modules.users.domain.model.RolePrivilege.*;

public enum Roles {
    BUYER(Set.of(CAN_BUY)),

    SELLER(Set.of(
            CAN_BUY,
            CAN_SELL,
            MANAGE_OWN_PRODUCTS,
            MANAGE_OWN_ORDERS
    )),

    ADMIN(Set.of(
            MANAGE_USERS,
            MANAGE_ALL_PRODUCTS,
            MANAGE_ALL_ORDERS,
            MANAGE_PAYMENTS,
            MANAGE_ROLES
    ));

    private final Set<RolePrivilege> privileges;

     Roles(Set<RolePrivilege> privileges) {
        this.privileges = privileges;
    }

    public Set<RolePrivilege> getPrivileges() {
         return Collections.unmodifiableSet(privileges);
    }

    public void addPrivilege(RolePrivilege privilege) {
         this.privileges.add(privilege);
    }

}
