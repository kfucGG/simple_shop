package com.example.productservice.controller;


import com.example.productservice.dto.DiscountDTO;
import com.example.productservice.services.interfaces.ProductService;
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
    public HttpStatus addDiscountToGroupOfProductByOrganization(@RequestParam("organizationId") Long organizationId,
                                                                @RequestBody DiscountDTO discount){
        productService.addDiscountToGroupOfProductByOrganization(organizationId, discount);
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
    public HttpStatus updateDiscountGroupOfProductByOrganization(@RequestParam("organizationId") Long organizationId,
                                                                 @RequestBody DiscountDTO discount) {
        productService.updateDiscountToGroupOfProductByOrganization(organizationId, discount);
        return HttpStatus.OK;
    }
}
