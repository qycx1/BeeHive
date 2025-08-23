    package com.hive.modules.users.domain.result;

    public enum AddAccountResult {
        INVALID_EMAIL("Email format is invalid"),
        INVALID_PHONE("Phone number format is invalid"),
        AGE_TOO_HIGH("Birthday cannot be more than 150 years ago"),
        BIRTHDAY_IN_FUTURE("Birthday cannot be in the future");

        private final String message;

        AddAccountResult(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }


