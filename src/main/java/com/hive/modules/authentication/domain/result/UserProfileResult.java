package com.hive.modules.authentication.domain.result;

import java.time.LocalDate;
import java.util.Set;

public record UserProfileResult (String userId, String firstName, String lastName, String email, Set<String> addresses, String phoneNumber, LocalDate birthday){
}
