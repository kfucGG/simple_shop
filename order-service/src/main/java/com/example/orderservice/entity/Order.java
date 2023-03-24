package com.example.orderservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_sq")
    private Long id;

    private Long productId;

    private Long userId;

    private LocalDateTime orderTime;


    public Order(Long productId, Long userId, LocalDateTime orderTime) {
        this.productId = productId;
        this.userId = userId;
        this.orderTime = orderTime;
    }
}
