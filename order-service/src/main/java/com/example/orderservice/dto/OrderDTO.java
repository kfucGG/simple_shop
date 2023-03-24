package com.example.orderservice.dto;

import com.example.orderservice.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long productId;
    private Long userId;
    private LocalDateTime orderTime;

    public OrderDTO(Order order) {
        this.productId = order.getProductId();
        this.orderTime = order.getOrderTime();
        this.userId = order.getUserId();
    }
}
