package com.example.productservice.entity;

import com.example.productservice.dto.ReviewDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(generator = "review_seq")
    @SequenceGenerator(name = "review_seq", sequenceName = "review_seq")
    private Long id;

    private String review;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Long userId;

    public Review(String review, Product product, Long userId) {
        this.review = review;
        this.product = product;
        this.userId = userId;
    }
}
