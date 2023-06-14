package com.lsandoval.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    // La configuracion para restTemplate necesita la anotacion LoadBalanced en caso
    // Se tengan varias instancias del servicio FRAUD registrado en eureka.
    // Por defecto el algoritmo del balanceador de carga alterna las solicitudes entre todas las instancias que existan
    // registradas del servicio FRAUD.
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
