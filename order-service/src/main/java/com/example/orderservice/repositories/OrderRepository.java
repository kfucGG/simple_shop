package com.example.orderservice.repositories;

import com.example.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<List<Order>> findOrdersByUserId(Long userId);

    @Query(value = "select * from orders where user_id = :userId and product_id = :productId", nativeQuery = true)
    Optional<List<Order>> findOrdersByUserIdAndProductId(@Param("userId") Long userId,
                                                         @Param("productId") Long productId);
}
