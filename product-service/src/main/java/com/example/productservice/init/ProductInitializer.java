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
public class ProductInitializer {

    private final ProductRepository productRepository;

    @PostConstruct
    @Transactional
    public void initProducts() {
        Product product = new Product("iphone 13", "shit from selekon valley", "apple",
                1000, 10);

        Product product1 = new Product("xiaomi", "made in china", "redmi",
                800, 60);

        Product product2 = new Product("Msi KATANA", "gaming notebook", "MSI",
                1200, 20);
        Product product3 = new Product("IPHONE 7", "old version of iphone", "apple",
                150, 5);
        Product product4 = new Product("PS 4", "gaming station", "SONY",
                500, 100);
        Product product5 = new Product("MacBook AIR", "notebook for work", "apple",
                1700, 17);
        Product product6 = new Product("SteelSeries SENSEI ROW", "gaming mouse", "STEELSERIES",
                70, 10);
        Product product7 = new Product("POCO C40", "smartphone", "apple",
                50, 10);
        Product product8 = new Product("HONOR 50", "good phone", "HUAWEI",
                300, 0);


        productRepository.saveAll(List.of(product, product1, product2, product3,
                product4, product5, product6, product7, product8));
    }
}
