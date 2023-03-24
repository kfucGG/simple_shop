package com.example.organizationservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {


    @Id
    @GeneratedValue(generator = "product_request_seq")
    @SequenceGenerator(name = "product_request_seq", sequenceName = "product_request_seq")
    private Long id;
    private String productName;
    private String productDescription;
    private Long organizationId;
    private Integer productPrice;
    private Integer amount;
}
