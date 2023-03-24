package com.example.productservice.services.interfaces;


import com.example.productservice.dto.ReviewDTO;

public interface ReviewService {
    void addReviewToProduct(ReviewDTO review, Long userId);
}
