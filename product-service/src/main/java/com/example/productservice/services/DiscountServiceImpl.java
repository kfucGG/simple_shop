package com.example.productservice.services;

import com.example.productservice.dto.DiscountDTO;
import com.example.productservice.entity.Discount;
import com.example.productservice.repositories.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;


    @Override
    public Discount findDiscountById(Long id) {
        return discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such discount"));
    }

    @Override
    @Transactional
    public Discount saveDiscount(DiscountDTO discount) {
        return discountRepository.save(new Discount(discount));
    }

    @Override
    @Transactional
    public Discount updateDiscount(Long discountId, DiscountDTO newDiscount) {
        Discount discount = findDiscountById(discountId);
        discount.setPercent(newDiscount.getPercent());
        discount.setStartOfDiscount(newDiscount.getStartOfDiscount());
        discount.setEndOfDiscount(newDiscount.getEndOfDiscount());
        return discountRepository.save(discount);
    }
}
