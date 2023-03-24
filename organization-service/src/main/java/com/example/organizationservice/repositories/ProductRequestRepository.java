package com.example.organizationservice.repositories;

import com.example.organizationservice.entity.ProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRequestRepository extends JpaRepository<ProductRequest, Long> {
}
