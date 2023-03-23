package com.example.productservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private String productName;
    private String productDescription;
    private String organization;
    private Integer productPrice;
    private Integer amount;
}
