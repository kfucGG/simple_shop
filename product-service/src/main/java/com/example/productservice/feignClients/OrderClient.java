package com.example.productservice.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("order-service")
public interface OrderClient {

    @PostMapping("/order/users")
    void addOrder(@RequestParam("product_id") Long productId);
}
