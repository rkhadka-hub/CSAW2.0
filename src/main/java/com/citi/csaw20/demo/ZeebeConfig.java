package com.citi.csaw20.demo;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.context.annotation.Bean;

public class ZeebeConfig {
    @Bean
    public ZeebeClient zeebeClient() {
        return ZeebeClient.newClientBuilder()
                .gatewayAddress("localhost:26500") // Replace with your broker's address
                .usePlaintext()
                .build();
    }
}
