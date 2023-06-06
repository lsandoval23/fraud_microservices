package com.lsandoval.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lasName,
        String email) {
}
