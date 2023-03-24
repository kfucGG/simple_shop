package com.example.productservice.repositories;

import com.example.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findProductsByOrganizationId(Long organization);
    Optional<List<Product>> findProductsByProductName(String productName);
}
