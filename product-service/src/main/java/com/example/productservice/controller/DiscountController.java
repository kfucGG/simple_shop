package com.example.productservice.controller;


import com.example.productservice.dto.DiscountDTO;
import com.example.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
public class DiscountController {

    private final ProductService productService;


    @PostMapping("/add/{productId}")
    public HttpStatus addDiscountToProduct(@RequestBody DiscountDTO discount,
                                           @PathVariable("productId") Long productId) {
        productService.addDiscountToProduct(productId, discount);
        return HttpStatus.OK;
    }

    @PostMapping("/add/organization")
    public HttpStatus addDiscountToGroupOfProductByOrganization(@RequestParam("organization") String organization,
                                                                @RequestBody DiscountDTO discount){
        productService.addDiscountToGroupOfProductByOrganization(organization, discount);
        return HttpStatus.OK;
    }

    @PostMapping("/add/name")
    public HttpStatus addDiscountToGroupOfProductByProductName(@RequestParam("productName") String productName,
                                                               @RequestBody DiscountDTO discount) {
        productService.addDiscountToGroupOfProductByProductName(productName, discount);
        return HttpStatus.OK;
    }

    @PostMapping("/update/{productId}")
    public HttpStatus updateProductDiscount(@PathVariable Long productId,
                                            @RequestBody DiscountDTO discount) {
        productService.updateDiscountToProduct(productId, discount);
        return HttpStatus.OK;
    }

    @PostMapping("/update/name")
    public HttpStatus updateDiscountGroupOfProductByProductName(@RequestParam("productName") String productName,
                                                                @RequestBody DiscountDTO discount) {
        productService.updateDiscountToGroupOfProductByProductName(productName, discount);
        return HttpStatus.OK;
    }

    @PostMapping("/update/organization")
    public HttpStatus updateDiscountGroupOfProductByOrganization(@RequestParam("organization") String organization,
                                                                 @RequestBody DiscountDTO discount) {
        productService.updateDiscountToGroupOfProductByOrganization(organization, discount);
        return HttpStatus.OK;
    }
}
