package com.example.buyerservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {

    private String productName;
    private String productDescription;
    private Long organizationId;
    private Integer productPrice;
    private Integer amount;
}
