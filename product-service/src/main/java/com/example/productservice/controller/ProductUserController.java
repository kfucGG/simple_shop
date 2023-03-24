package com.example.productservice.controller;


import com.example.productservice.dto.GradeDTO;
import com.example.productservice.dto.ReviewDTO;
import com.example.productservice.services.interfaces.GradeService;
import com.example.productservice.services.interfaces.ProductService;
import com.example.productservice.services.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductUserController {

    private final ProductService productService;
    private final GradeService gradeService;
    private final ReviewService reviewService;


    @PostMapping("/buy")
    public HttpStatus buyProduct(@RequestParam("product_id") Long productId,
                                 @RequestHeader("user-id") Long userId) {
        productService.buyProduct(productId, userId);
        return HttpStatus.OK;
    }

    @PostMapping("/grade")
    public HttpStatus makeGrade(@RequestBody GradeDTO grade,
                                @RequestHeader("user-id") Long userId) {
        gradeService.addGradeToProduct(grade,userId);
        return HttpStatus.OK;
    }

    @PostMapping("/review")
    public HttpStatus makeReview(@RequestBody ReviewDTO review,
                                 @RequestHeader("user-id") Long userId) {
        reviewService.addReviewToProduct(review, userId);
        return HttpStatus.OK;
    }
}
