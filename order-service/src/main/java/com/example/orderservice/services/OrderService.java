package com.example.orderservice.services;


import com.example.orderservice.entity.Order;
import com.example.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public List<Order> getOrderByProductAndUserId(Long productId, Long userId) {
        Optional<List<Order>> orders = orderRepository.findOrdersByUserIdAndProductId(userId, productId);
        if (orders.isPresent()) {
            System.out.println(orders.get());
            return orders.get();
        }
        return Collections.emptyList();
    }

    @Transactional
    public void refundUserOrderIfDayNotLeft(Long userId, Long orderId) {
        Order order = getOrderById(orderId);
        if (order.getOrderTime().plusDays(1L).isBefore(LocalDateTime.now()))
            throw new RuntimeException("can not cancel order cause days gone");

        orderRepository.deleteById(order.getId());
    }
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("no such order"));
    }

    public List<Order> getAllOrdersByUserId(Long userId) {
        return orderRepository.findOrdersByUserId(userId)
                .orElseThrow(() -> new RuntimeException("user dont have orders"));
    }
}
