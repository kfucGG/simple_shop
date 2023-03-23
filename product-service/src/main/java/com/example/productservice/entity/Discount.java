package com.example.productservice.entity;


import com.example.productservice.dto.DiscountDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(generator = "discount_seq")
    @SequenceGenerator(name = "discount_seq", sequenceName = "discount_seq")
    private Long id;
    @OneToMany(mappedBy = "productDiscount")
    private List<Product> products;
    private Integer percent;
    private LocalDate startOfDiscount;
    private LocalDate endOfDiscount;

    public Discount(DiscountDTO discount) {
        this.percent = discount.getPercent();
        this.endOfDiscount = discount.getEndOfDiscount();
        this.startOfDiscount = discount.getStartOfDiscount();
    }
}
