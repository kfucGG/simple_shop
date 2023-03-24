package com.example.buyerservice.feignClient;


import com.example.buyerservice.dto.GradeDTO;
import com.example.buyerservice.dto.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
public interface ProductFeignClient {

    @PostMapping("/products/buy")
    HttpStatus buyProduct(@RequestParam("product_id") Long productId,
                          @RequestHeader("user-id") Long userId);

    @PostMapping("/products/grade")
    HttpStatus makeGrade(@RequestBody GradeDTO grade,
                         @RequestHeader("user-id") Long userId);

    @PostMapping("/products/review")
    HttpStatus makeReview(@RequestBody ReviewDTO review,
                          @RequestHeader("user-id") Long userId);
}
