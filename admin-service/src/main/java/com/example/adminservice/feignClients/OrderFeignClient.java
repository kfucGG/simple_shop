package com.example.adminservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("order-service")
public interface OrderFeignClient {
}
