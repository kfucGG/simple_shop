package com.example.adminservice.controllers;


import com.example.adminservice.dto.DiscountDTO;
import com.example.adminservice.feignClients.DiscountFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/discounts")
@RequiredArgsConstructor
public class AdminDiscountController {

    private final DiscountFeignClient discountClient;

    @PostMapping("/add/{productId}")
    public HttpStatus addDiscountToProduct(@PathVariable("productId") Long productId,
                                           @RequestBody DiscountDTO discount) {
        return discountClient.addDiscountToProduct(discount, productId);
    }

    @PostMapping("/add/organization")
    public HttpStatus addDiscountToGroupOfProductByOrganization(@RequestParam Long organizationId,
                                                                @RequestBody DiscountDTO discount) {
        return discountClient.addDiscountToGroupOfProductByOrganization(organizationId  , discount);
    }

    @PostMapping("/add/name")
    public HttpStatus addDiscountToGroupOfProductByProductName(@RequestParam String productName,
                                                                @RequestBody DiscountDTO discount) {
        return discountClient.addDiscountToGroupOfProductByProductName(productName, discount);
    }
    @PatchMapping("/update/{productId}")
    public HttpStatus updateProductDiscount(@PathVariable Long productId,
                                     @RequestBody DiscountDTO discount) {
        return discountClient.updateProductDiscount(productId, discount);
    }

    @PatchMapping ("/update/name")
    public HttpStatus updateDiscountGroupOfProductByProductName(@RequestParam String productName,
                                                         @RequestBody DiscountDTO discount) {
        return discountClient.updateDiscountGroupOfProductByProductName(productName, discount);
    }

    @PatchMapping("/update/organization")
    public HttpStatus updateDiscountGroupOfProductByOrganization(@RequestParam Long organizationId,
                                                          @RequestBody DiscountDTO discount) {
        return discountClient.updateDiscountGroupOfProductByOrganization(organizationId, discount);
    }
}
