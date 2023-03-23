package com.example.productservice.services;

import com.example.productservice.dto.DiscountDTO;
import com.example.productservice.entity.Discount;

public interface DiscountService {

    Discount findDiscountById(Long id);

    Discount saveDiscount(DiscountDTO discount);

    Discount updateDiscount(Long discountId, DiscountDTO newDiscount);
}
