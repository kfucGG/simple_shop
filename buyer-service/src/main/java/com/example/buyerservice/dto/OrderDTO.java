package com.example.buyerservice.dto;

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

}
