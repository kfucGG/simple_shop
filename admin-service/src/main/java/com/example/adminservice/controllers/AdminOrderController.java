package com.example.adminservice.controllers;


import com.example.adminservice.dto.OrderDTO;
import com.example.adminservice.feignClients.OrderFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
public class AdminOrderController {

    private final OrderFeignClient orderClient;

    @GetMapping("/{userId}")
    public List<OrderDTO> getOrderHistoryOfUser(@PathVariable Long userId) {
        return orderClient.getUserOrders(userId);
    }
}
