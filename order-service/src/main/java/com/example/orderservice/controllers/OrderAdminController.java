package com.example.orderservice.controllers;


import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order/admin")
@RequiredArgsConstructor
public class OrderAdminController {

    private final OrderService orderService;


    @GetMapping("/{userId}")
    public List<OrderDTO> getUserOrders(@PathVariable("userId") Long userId) {
        return orderService.getAllOrdersByUserId(userId)
                .stream().map(OrderDTO::new).collect(Collectors.toList());
    }
}
