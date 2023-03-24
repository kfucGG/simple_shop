package com.example.productservice.feignClients;

import com.example.productservice.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("order-service")
public interface OrderFeignClient {

    @PostMapping("/order/users")
    HttpStatus addOrder(@RequestParam("product_id") Long productId,
                        @RequestHeader("user-id") Long userId);

    @GetMapping("/order/users/{productId}")
    List<OrderDTO> getOrderByProductId(@PathVariable Long productId,
                                       @RequestHeader("user-id") Long userId);
}
