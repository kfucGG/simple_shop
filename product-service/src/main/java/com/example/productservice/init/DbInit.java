package com.example.productservice.init;


import com.example.productservice.entity.Product;
import com.example.productservice.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInit {

    private final ProductRepository productRepository;

    @PostConstruct
    @Transactional
    public void initTestProducts() {
        Product product = new Product();
        product.setProductName("test1");
        product.setProductPrice(300);
        product.setOrganizationId(3000L);

        Product product2 = new Product();
        product2.setProductName("test2");
        product2.setProductPrice(2002);
        product2.setAmount(200);
        productRepository.saveAll(List.of(product, product2));
    }
}
