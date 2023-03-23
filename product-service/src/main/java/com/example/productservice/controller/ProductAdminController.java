package com.example.productservice.controller;


import com.example.productservice.dto.ProductDTO;
import com.example.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductAdminController {

    private final ProductService productService;


    @PostMapping("/add")
    public HttpStatus addNewProduct(@RequestBody ProductDTO product) {
        productService.addProduct(product);
        return HttpStatus.OK;
    }

    @PostMapping("/{productId}/update")
    public HttpStatus updateProduct(@RequestBody ProductDTO product,
                                    @PathVariable Long productId) {
        productService.updateProduct(productId, product);
        return HttpStatus.OK;
    }

}
