package com.example.productservice.services;

import com.example.productservice.dto.GradeDTO;
import com.example.productservice.dto.OrderDTO;
import com.example.productservice.entity.Grade;
import com.example.productservice.entity.Product;
import com.example.productservice.feignClients.OrderFeignClient;
import com.example.productservice.repositories.GradeRepository;
import com.example.productservice.services.interfaces.GradeService;
import com.example.productservice.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final OrderFeignClient orderClient;
    private final GradeRepository gradeRepository;
    private final ProductService productService;


    @Override
    @Transactional
    public void addGradeToProduct(GradeDTO grade, Long userId) {
        List<OrderDTO> orders = orderClient.getOrderByProductId(grade.getProductId(), userId);
        if (orders.isEmpty())
            throw new RuntimeException("you can not make grade cause you dont bought that product");
        Product gradeProduct = productService.findProductById(grade.getProductId());
        Grade newGrade = new Grade(grade.getGrade(), userId, gradeProduct);
        gradeRepository.save(newGrade);
    }
}
