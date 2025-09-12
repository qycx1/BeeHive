package com.hive.modules.authentication.application.response;

import com.hive.modules.users.domain.model.Roles;

import java.time.LocalDate;
import java.util.Set;

public record UserProfileResult (String userId,String authId ,String firstName, String lastName, String email, Set<String> addresses, String phoneNumber, LocalDate birthday, Roles roles){
}
