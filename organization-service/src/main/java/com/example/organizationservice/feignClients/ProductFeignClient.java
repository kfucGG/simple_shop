package com.example.organizationservice.feignClients;


import com.example.organizationservice.entity.ProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("product-service")
public interface ProductFeignClient {

    @PostMapping("/products/add")
    HttpStatus addNewProduct(@RequestBody ProductRequest product);
}
