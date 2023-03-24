package com.example.productservice.services;

import com.example.productservice.dto.OrderDTO;
import com.example.productservice.dto.ReviewDTO;
import com.example.productservice.entity.Product;
import com.example.productservice.entity.Review;
import com.example.productservice.feignClients.OrderFeignClient;
import com.example.productservice.repositories.ReviewRepository;
import com.example.productservice.services.interfaces.ProductService;
import com.example.productservice.services.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ProductService productService;
    private final OrderFeignClient orderClient;
    private final ReviewRepository reviewRepository;



    @Override
    @Transactional
    public void addReviewToProduct(ReviewDTO review, Long userId) {
        List<OrderDTO> orders = orderClient.getOrderByProductId(review.getProductId(), userId);
        if (orders.isEmpty())
            throw new RuntimeException("you can not set review cause u dont bought this product");
        Product reviewProduct = productService.findProductById(review.getProductId());
        Review newReview = new Review(review.getReview(), reviewProduct, userId);
        reviewRepository.save(newReview);
    }
}
