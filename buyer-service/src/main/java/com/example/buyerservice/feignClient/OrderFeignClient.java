package com.example.buyerservice.feignClient;

import com.example.buyerservice.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("order-service")
public interface OrderFeignClient {

    @GetMapping("/order/users")
    List<OrderDTO> getUserOrders(@RequestHeader("user-id") Long userId);

    @DeleteMapping("/order/users/delete")
    HttpStatus deleteUserOrder(@RequestHeader("user-id") Long userId,
                               @RequestParam("orderId") Long orderId);
}
