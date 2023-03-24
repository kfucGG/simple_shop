package com.example.adminservice.feignClients;


import com.example.adminservice.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("order-service")
public interface OrderFeignClient {

    @GetMapping("/order/admin/{userId}")
    List<OrderDTO> getUserOrders(@PathVariable("userId") Long userId);
}
