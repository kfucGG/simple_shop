package com.example.productservice.services.interfaces;

import com.example.productservice.dto.GradeDTO;

public interface GradeService {
    void addGradeToProduct(GradeDTO grade, Long userId);
}
