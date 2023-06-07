package com.lsandoval.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
