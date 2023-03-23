package com.example.orderservice.controllers;


import com.example.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/users")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public void addOrder(@RequestParam("product_id") Long productId,
                         @RequestHeader("user-id") Long userId) {
        orderService.addOrder(userId, productId);
    }
}
