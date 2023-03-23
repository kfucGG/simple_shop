package com.example.productservice.controller;


import com.example.productservice.services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ProductUserController {

    private final ProductServiceImpl productServiceImpl;


    @PostMapping("/buy")
    public void buyProduct(@RequestParam("product_id") Long productId) {
        productServiceImpl.buyProduct(productId);
    }

    @PostMapping("/grade")
    public void makeGrade(@RequestHeader("user-id") Long userId,
                          @RequestParam("grade") Integer grade,
                          @RequestParam("product_id") Long productId) {

    }

    @PostMapping("/review")
    public void makeReview() {

    }
}
