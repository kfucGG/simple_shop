package com.example.buyerservice.controllers;


import com.example.buyerservice.dto.GradeDTO;
import com.example.buyerservice.dto.OrderDTO;
import com.example.buyerservice.dto.ReviewDTO;
import com.example.buyerservice.feignClient.OrderFeignClient;
import com.example.buyerservice.feignClient.ProductFeignClient;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
@RequiredArgsConstructor
public class BuyerController {

    private final ProductFeignClient productClient;
    private final OrderFeignClient orderClient;

    @PostMapping("/buy")
    public HttpStatus buyProduct(@RequestParam Long productId,
                                 @RequestHeader("user-id") Long userId) {
        return productClient.buyProduct(productId, userId);
    }

    @PostMapping("/grade")
    public HttpStatus makeGradeOnProduct(@RequestBody GradeDTO grade,
                                         @RequestHeader("user-id") Long userId) {
        return productClient.makeGrade(grade, userId);
    }

    @PostMapping("/review")
    public HttpStatus makeReviewOnProduct(@RequestBody ReviewDTO review,
                                          @RequestHeader("user-id") Long userId) {
        return productClient.makeReview(review, userId);
    }

    @GetMapping("/orders")
    public List<OrderDTO> getHistoryOfOrders(@RequestHeader("user-id") Long userId) {
        return orderClient.getUserOrders(userId);
    }

    @DeleteMapping("/orders/refund")
    public HttpStatus refundProduct(@RequestHeader("user-id") Long userId,
                                    @RequestParam("orderId") Long orderId) {
        return orderClient.deleteUserOrder(userId, orderId);
    }
}
