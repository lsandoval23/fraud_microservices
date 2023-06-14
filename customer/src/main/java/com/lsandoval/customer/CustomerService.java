package com.lsandoval.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();



        // TODO: check if email valid
        // TODO: check if email not taken

        // store customer in db
        // Usamos save and flush para poder obtener el id del nuevo registro
        customerRepository.saveAndFlush(customer);

        // check if fraudster
        // Cambiamos la ip y puerto por el nombre de la aplicacion registrada en el servidor eureka
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }



        // TODO: send notification
    }
}
