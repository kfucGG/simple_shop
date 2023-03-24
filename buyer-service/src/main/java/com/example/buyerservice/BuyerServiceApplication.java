package com.example.buyerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuyerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyerServiceApplication.class, args);
    }

}
