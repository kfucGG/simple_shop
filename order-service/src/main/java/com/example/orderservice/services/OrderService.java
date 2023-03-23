package com.example.orderservice.services;


import com.example.orderservice.entity.Order;
import com.example.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {


    private final OrderRepository orderRepository;


    @Transactional
    public void addOrder(Long userId, Long productId) {
        Order order = new Order(productId, userId, LocalDateTime.now());
        orderRepository.save(order);
    }


    public List<Order> getAllOrdersByUserId(Long userId) {
        return orderRepository.findOrdersByUserId(userId)
                .orElseThrow(() -> new RuntimeException("user dont have orders"));
    }
}
