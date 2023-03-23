package com.example.adminservice.feignClients;


import com.example.adminservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service", contextId = "product")
public interface ProductFeignClient {

    @PostMapping("/products/add")
    HttpStatus addNewProduct(@RequestBody ProductDTO product);

    @PostMapping("/products/{productId}/update")
    HttpStatus updateProduct(@RequestBody ProductDTO product,
                             @PathVariable Long productId);
}
