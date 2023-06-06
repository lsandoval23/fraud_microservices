package com.lsandoval.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lasName())
                .email(request.email())
                .build();

        // TODO: check if email valid
        // TODO: check if email not taken
        // TODO: store customer in db

    }
}
