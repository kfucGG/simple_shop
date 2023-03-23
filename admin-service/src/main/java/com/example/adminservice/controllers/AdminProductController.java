package com.example.adminservice.controllers;


import com.example.adminservice.dto.ProductDTO;
import com.example.adminservice.feignClients.ProductFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductFeignClient productClient;


    @PostMapping("/add")
    public HttpStatus addProduct(@RequestBody ProductDTO productDTO) {
        return productClient.addNewProduct(productDTO);
    }

    @PostMapping("/{productId}/update")
    public HttpStatus updateProduct(@PathVariable Long productId,
                                    @RequestBody ProductDTO productDTO) {
        return productClient.updateProduct(productDTO, productId);
    }

}
