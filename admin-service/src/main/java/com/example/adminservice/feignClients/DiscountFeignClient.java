package com.example.adminservice.feignClients;


import com.example.adminservice.dto.DiscountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", contextId = "discount")
public interface DiscountFeignClient {

    @PostMapping("/discount/add/{productId}")
    HttpStatus addDiscountToProduct(@RequestBody DiscountDTO discount,
                                    @PathVariable Long productId);

    @PostMapping("/discount/add/organization")
    HttpStatus addDiscountToGroupOfProductByOrganization(@RequestParam String organization,
                                                         @RequestBody DiscountDTO discount);

    @PostMapping("/discount/add/name")
    HttpStatus addDiscountToGroupOfProductByProductName(@RequestParam String productName,
                                                        @RequestBody DiscountDTO discount);

    @PostMapping("/discount/update/{productId}")
    HttpStatus updateProductDiscount(@PathVariable Long productId,
                                     @RequestBody DiscountDTO discount);

    @PostMapping("/discount/update/name")
    HttpStatus updateDiscountGroupOfProductByProductName(@RequestParam String productName,
                                                         @RequestBody DiscountDTO discount);

    @PostMapping("/discount/update/organization")
    HttpStatus updateDiscountGroupOfProductByOrganization(@RequestParam String organization,
                                                          @RequestBody DiscountDTO discount);
}
