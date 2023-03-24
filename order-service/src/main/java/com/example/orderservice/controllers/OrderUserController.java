package com.example.orderservice.controllers;


import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order/users")
@RequiredArgsConstructor
public class OrderUserController {

    private final OrderService orderService;


    @GetMapping("/{productId}")
    public List<OrderDTO> getOrderByProductId(@PathVariable Long productId,
                                              @RequestHeader("user-id") Long userId) {
        return orderService.getOrderByProductAndUserId(productId, userId)
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<OrderDTO> getUserOrders(@RequestHeader("user-id") Long userId) {
        return orderService.getAllOrdersByUserId(userId)
                .stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public HttpStatus addOrder(@RequestParam("product_id") Long productId,
                               @RequestHeader("user-id") Long userId) {
        orderService.addOrder(userId, productId);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteUserOrder(@RequestHeader("user-id") Long userId,
                                      @RequestParam("orderId") Long orderId) {
        orderService.refundUserOrderIfDayNotLeft(userId, orderId);
        return HttpStatus.OK;
    }
}
